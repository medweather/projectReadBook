package book.project;

import book.project.model.Book;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class ControllerLazy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject private ListQuery listQuery;

    private List<Book> books = new ArrayList<>();

    private LazyDataModel<Book> dataModel;

    @PostConstruct
    public void init() {

        this.dataModel = new LazyDataModel<Book>() {

            private static final long serialVersionUID = 1L;

            @Override
            public List<Book> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                setRowCount(listQuery.getTotalRegistros().intValue());
                return listQuery.getBooks(first, pageSize, sortField, SortOrder.ASCENDING.equals(sortOrder));
            }
        };
    }

    public LazyDataModel<Book> getDataModel() {
        return dataModel;
    }

    public List<Book> getBooks() {
        return books;
    }
}
