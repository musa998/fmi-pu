package sample.updateBook;

import entityes.Book;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.viewBook.ViewBookController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Connection.DbConnector.getConnection;

public class UpdateBookController {


    public TextField txtSearchTitle;
    public TextField txtISBN;
    public TextField txtPublishYear;
    public TextField txtRating;
    public TextField txtITitle;
    public TextField txtAuthorName;

    public void editBook(ActionEvent actionEvent) {
        ResultSet rs;
        String cquery = "SELECT * FROM BOOKS WHERE TITLE = '" + txtSearchTitle.getText() + "'";
        String updateQuery = "UPDATE Books SET title = ?, year = ?, isbn = ?, avg_rating = ? WHERE title" +
                " = '" + txtSearchTitle.getText() + "'";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        // rs = execQuery(cquery);
        try {
            statement = connection.prepareStatement(cquery);
            rs = statement.executeQuery(cquery);
            if (!rs.isBeforeFirst() ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Book not found");
                alert.showAndWait();
            }
            else {
                String title = null;
                int year = 0;
                int isbn =0;
                double avgRating =0;
                while (rs.next()) {
                     title = rs.getString("title");
                     year = rs.getInt("year");
                     isbn = rs.getInt("isbn");
                     avgRating = rs.getDouble("avg_rating");
                }
                if (txtITitle.getText().isEmpty() == false){
                    title = txtITitle.getText();
                }
                if (txtPublishYear.getText().isEmpty() == false){
                    year =Integer.parseInt(txtPublishYear.getText());
                }
                if (txtISBN.getText().isEmpty() == false){
                    isbn = Integer.parseInt(txtISBN.getText());
                }
                if (txtRating.getText().isEmpty() == false){
                    avgRating = Double.parseDouble(txtRating.getText());
                }
                statement = connection.prepareStatement(updateQuery);
                statement.setString(1, title);
                statement.setInt(2, year);
                statement.setInt(3, isbn);
                statement.setDouble(4, avgRating);
                statement.execute();
                System.out.println("Updated");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
