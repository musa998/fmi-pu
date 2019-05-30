package sample.updateBook;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Connection.DbConnector.getConnection;

public class UpdateAuthorController {
    public AnchorPane rootPane;
    public TextField txtSearchTitle;
    public TextField txtAuthorName;
    public TextArea txtAboutAuthor;

    public void editAuthor(ActionEvent actionEvent) {
        ResultSet rs;
        ResultSet resultSet2;
        String cquery = "SELECT * FROM Authors WHERE name = '" + txtSearchTitle.getText() + "'";
        String updateQuery = "UPDATE Authors SET name = ?, about = ? WHERE name" +
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
                alert.setContentText("Author not found");
                alert.showAndWait();
            } else {

                String name = null;
                String aboutAuthor = null;
                while (rs.next()) {
                    name = rs.getString("name");
                    aboutAuthor = rs.getString("about");
                }
                if (txtAuthorName.getText().isEmpty() == false) {
                    name = txtAuthorName.getText();
                }
                if (txtAboutAuthor.getText().isEmpty() == false) {
                    aboutAuthor = txtAboutAuthor.getText();
                }
                statement = connection.prepareStatement(updateQuery);
                statement.setString(1, name);
                statement.setString(2, aboutAuthor);
//                statement.setInt(3, isbn);
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
