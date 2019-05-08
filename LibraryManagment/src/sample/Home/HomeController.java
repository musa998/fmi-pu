package sample.Home;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController implements Initializable {
    @FXML
    private Button btnCheckOutBook;
    @FXML
    private Button btnAddMember;
    @FXML
    private Button btnAddBook;
    @FXML
    private Button btnAddBookCopy;
    @FXML
    private Button btnSignOut;
    @FXML
    private Button btnRecord;
    @FXML
    private Button btnOverdue;
    @FXML
    private Label welcomeLBL;


    @FXML
    public void addBook() {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/AddBook.fxml"));
            Scene scene = new Scene(blah);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void viewBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/viewBook/ViewBook.fxml"));
            Scene scene = new Scene(blah);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/updateBook/UpdateBook.fxml"));
            Scene scene = new Scene(blah);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/deleteBook/DeleteBook.fxml"));
            Scene scene = new Scene(blah);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
