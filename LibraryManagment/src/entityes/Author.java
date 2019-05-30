package entityes;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Author {
    private SimpleStringProperty name;
    private SimpleStringProperty about;

    public Author(String name, String about) {
        this.name = new SimpleStringProperty(name);
        this.about = new SimpleStringProperty(about);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getAbout() {
        return about.get();
    }

    public void setAbout(String about) {
        this.about = new SimpleStringProperty(about);
    }
}
