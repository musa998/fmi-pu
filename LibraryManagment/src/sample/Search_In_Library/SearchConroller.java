package sample.Search_In_Library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import sample.Home.HomeController;

import java.io.IOException;

public class SearchConroller extends HomeController {

    public AnchorPane rootPane;

    public void searchInLibrary(ActionEvent actionEvent) {


    }

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/home/home.fxml"));
        rootPane.getChildren().setAll(blah);
    }
}
