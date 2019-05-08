package sample.deleteBook;

import Connection.DbConnector;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Connection.DbConnector.getConnection;

public class DeleteBookController {
    public TextField txtSearchTitle;

    public void deleteBook(ActionEvent actionEvent) {
        ResultSet rs;
        String cquery = "SELECT * FROM BOOKS WHERE TITLE = '" + txtSearchTitle.getText() + "'";
        String deleteSql = "Delete FROM BOOKS WHERE TITLE = '" + txtSearchTitle.getText() + "'";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(cquery);
            rs = statement.executeQuery(cquery);
            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Book not found");
                alert.showAndWait();
            } else {
                statement = connection.prepareStatement(deleteSql);
                statement.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Book deleted");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
