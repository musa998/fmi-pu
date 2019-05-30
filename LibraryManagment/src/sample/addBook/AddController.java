package sample.addBook;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AddController {
    public AnchorPane rootPane;

    public void addBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/AddBook.fxml"));
            rootPane.getChildren().setAll(blah);
//            Scene scene = new Scene(blah);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddGenre(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/AddGenre.fxml"));
            rootPane.getChildren().setAll(blah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAuthor(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/AddAuthor.fxml"));
            rootPane.getChildren().setAll(blah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/home/home.fxml"));
        rootPane.getChildren().setAll(blah);
    }
}
