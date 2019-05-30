package sample.addBook;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Connection.DbConnector.getConnection;

public class AddGenreController {
    public AnchorPane rootPane;
    public TextField txtGenreType;

    public void addGenre(ActionEvent actionEvent) throws SQLException {
        String genreType = txtGenreType.getText();
        ResultSet rs;

        if (genreType.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter All the Fields ");
            alert.showAndWait();
        } else {
            String sql2 = "INSERT INTO Genre " +
                    "VALUES (NULL,?)";
            String getGenre = "SELECT * FROM GENRE WHERE GenreType = '"
                    + genreType + "'";

            PreparedStatement state = null;
            Connection conn = getConnection();

            try {
                state = conn.prepareStatement(getGenre);
                rs = state.executeQuery(getGenre);
                if (rs.isBeforeFirst()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("This Genre already exist");
                    alert.showAndWait();
                    return;
                }
                state = conn.prepareStatement(sql2);
                state.setString(1, genreType);
                state.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Succesfully added");
                alert.showAndWait();

            } catch (SQLException var17) {
                var17.printStackTrace();
            }finally {
                try {
                    state.close();
                    conn.close();
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }
        }
    }

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/Add.fxml"));
        rootPane.getChildren().setAll(blah);
    }
}
