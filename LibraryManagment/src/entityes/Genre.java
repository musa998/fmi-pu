package entityes;

import javafx.beans.property.SimpleStringProperty;

public class Genre {
    private SimpleStringProperty genreType;

    public Genre(String genreType) {
        this.genreType = new SimpleStringProperty(genreType);;
    }

    public String getGenreType() {
        return genreType.get();
    }

    public void setGenreType(String genreType) {
        this.genreType = new SimpleStringProperty(genreType);
    }
}
