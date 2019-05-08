package entityes;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleStringProperty title;
    private SimpleIntegerProperty year;
    private SimpleIntegerProperty isbn;
    private SimpleDoubleProperty avRating;

    public Book(String title, int year, int isbn, double avRating) {
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.isbn = new SimpleIntegerProperty(isbn);
        this.avRating = new SimpleDoubleProperty(avRating);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title = new SimpleStringProperty(title);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year = new SimpleIntegerProperty(year);
    }

    public int getIsbn() {
        return isbn.get();
    }

    public void setIsbn(int isbn) {
        this.isbn = new SimpleIntegerProperty(isbn);
    }

    public double getAvRating() {
        return avRating.get();
    }

    public void setAvRating(double avRating) {
        this.avRating = new SimpleDoubleProperty(avRating);
    }
}