package book.project;

import book.project.model.Book;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.*;

public class LazyBookDataModel extends LazyDataModel<Book> {

    private List<Book> datasource;

    public LazyBookDataModel(List<Book> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Book getRowData(String rowKey) {
        for(Book book : datasource) {
            if(String.valueOf(book.getId()).equals(rowKey))
                return book;
        }

        return null;
    }

    @Override
    public Object getRowKey(Book book) {
        return book.getId();
    }


    @Override
    public List<Book> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters)
    {
        List<Book> data = new ArrayList<Book>();
        for(Book book : datasource) {
            boolean match = true;

            //filter
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(book.getClass().getField(filterProperty).get(book));

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
                data.add(book);
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
