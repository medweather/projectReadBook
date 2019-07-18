package book.project.lazy;

import book.project.BookDAO;
import org.primefaces.model.SortOrder;

import java.util.Comparator;

public class LazySorter implements Comparator<BookDAO> {

    private String sortField;

    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(BookDAO bookDAO1, BookDAO bookDAO2) {
        try {
            Object value1 = BookDAO.class.getField(this.sortField).get(bookDAO1);
            Object value2 = BookDAO.class.getField(this.sortField).get(bookDAO2);

            int value = ((Comparable)value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
