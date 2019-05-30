package sample.updateBook;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UpdateController {
    public AnchorPane rootPane;

    public void updateBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/updateBook/UpdateBook.fxml"));
            rootPane.getChildren().setAll(blah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGenre(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader()
                    .getResource("sample/updateBook/UpdateGenre.fxml"));
            rootPane.getChildren().setAll(blah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAuthor(ActionEvent actionEvent)  {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader()
                    .getResource("sample/updateBook/UpdateAuthor.fxml"));
            rootPane.getChildren().setAll(blah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnToHome(ActionEvent actionEvent)throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/home/home.fxml"));
        rootPane.getChildren().setAll(blah);
    }
}
