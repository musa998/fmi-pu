package sample.updateBook;

import entityes.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.viewBook.ViewBookController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Connection.DbConnector.getConnection;

public class UpdateBookController {


    public TextField txtSearchTitle;
//    public TextField txtISBN;
    public TextField txtPublishYear;
    public TextField txtITitle;
    public AnchorPane rootPane;

    public void editBook(ActionEvent actionEvent) {
        ResultSet rs;
        ResultSet resultSet2;
        String cquery = "SELECT * FROM BOOKS WHERE Isbn = '" + txtSearchTitle.getText() + "'";
        String updateQuery = "UPDATE Books SET title = ?, year = ? WHERE isbn" +
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
                alert.setContentText("Book not found");
                alert.showAndWait();
            } else {

                String title = null;
                String authorName = null;
                int year = 0;
                int isbn = 0;
                double avgRating = 0;
                while (rs.next()) {
                    title = rs.getString("title");
                    year = rs.getInt("year");
//                    isbn = rs.getInt("isbn");
//                     avgRating = rs.getDouble("avg_rating");
                }
                if (txtITitle.getText().isEmpty() == false) {
                    title = txtITitle.getText();
                }
                if (txtPublishYear.getText().isEmpty() == false) {
                    year = Integer.parseInt(txtPublishYear.getText());
                }
//                if (txtISBN.getText().isEmpty() == false) {
//                    isbn = Integer.parseInt(txtISBN.getText());
//                }

                statement = connection.prepareStatement(updateQuery);
                statement.setString(1, title);
                statement.setInt(2, year);
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
