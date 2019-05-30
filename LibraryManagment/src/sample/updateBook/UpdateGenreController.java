package sample.updateBook;

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

public class UpdateGenreController {
    public AnchorPane rootPane;
    public TextField txtSearchTitle;
    public TextField txtGenreType;

    public void editGenre(ActionEvent actionEvent) {
        ResultSet rs;
        ResultSet resultSet2;
        String cquery = "SELECT * FROM Genre WHERE GenreType = '" + txtSearchTitle.getText() + "'";
        String updateQuery = "UPDATE Genre SET GenreType = ? WHERE GenreType" +
                " = '" + txtSearchTitle.getText() + "'";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        // rs = execQuery(cquery);
        try {
            statement = connection.prepareStatement(cquery);
            rs = statement.executeQuery(cquery);

            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Genre not found");
                alert.showAndWait();
            } else {

                String genreType = null;
                while (rs.next()) {
                    genreType = rs.getString("GenreType");
                }
                if (txtGenreType.getText().isEmpty() == false) {
                    genreType = txtGenreType.getText();
                }

                statement = connection.prepareStatement(updateQuery);
                statement.setString(1, genreType);
                statement.execute();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Succesfully updated");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/home/home.fxml"));
        rootPane.getChildren().setAll(blah);
    }
}
