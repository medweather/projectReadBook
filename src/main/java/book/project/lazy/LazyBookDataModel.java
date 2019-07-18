package book.project.lazy;

import book.project.BookDAO;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.*;

public class LazyBookDataModel extends LazyDataModel<BookDAO> {

    private List<BookDAO> datasource;

    public LazyBookDataModel(List<BookDAO> datasource) {
        this.datasource = datasource;
    }

    @Override
    public BookDAO getRowData(String rowKey) {
        for(BookDAO bookDAO : datasource) {
            if(bookDAO.getId().equals(rowKey))
                return bookDAO;
        }

        return null;
    }

    @Override
    public Object getRowKey(BookDAO bookDAO) {
        return bookDAO.getId();
    }

    @Override
    public List<BookDAO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<BookDAO> data = new ArrayList<BookDAO>();

        //filter
        for(BookDAO bookDAO : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(bookDAO.getClass().getField(filterProperty).get(bookDAO));

                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        }
                        else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }

            if(match) {
                data.add(bookDAO);
            }
        }

        //sort
        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}
