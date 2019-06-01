package entityes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book_Genre {
    private SimpleStringProperty title;
    private SimpleIntegerProperty year;
    private SimpleIntegerProperty isbn;
    private SimpleStringProperty genreType;

    public Book_Genre(String title, int year, int isbn, String genreType) {
        this.title =  new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.isbn = new SimpleIntegerProperty(isbn);
        this.genreType =  new SimpleStringProperty(genreType);
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

    public String getGenreType() {
        return genreType.get();
    }

    public void setGenreType(String genreType) {
        this.genreType = new SimpleStringProperty(genreType);
    }
}
