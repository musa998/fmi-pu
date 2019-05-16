package sample.viewBook;

import com.sun.org.apache.xpath.internal.FoundIndex;
import entityes.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static Connection.DbConnector.getConnection;

public class ViewBookController implements Initializable {
    public TextField title;
    public TableColumn colTitle;
    public TableColumn colIsbn;
    public TableColumn colYear;
    public TableColumn colAvgRating;
    public TableView<Book> tableView;

    public void searchBook(ActionEvent actionEvent) {
        ResultSet rs;
        String cquery = "SELECT * FROM BOOKS WHERE TITLE = '" + title.getText() + "'";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        // rs = execQuery(cquery);
        try {
            statement = connection.prepareStatement(cquery);
            rs = statement.executeQuery(cquery);
            while (rs.next()) {
                String title = rs.getString("title");
                int year = rs.getInt("year");
                int isbn = rs.getInt("isbn");
//                double avgRating = rs.getDouble("avg_rating");
                Book book = new Book(title, year, isbn);
               // ObservableList<Book> books = FXCollections.observableArrayList();
                tableView.getItems().add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        tableview.getItems().setAll(list);

    }

    public ResultSet execQuery(String query) {
        ResultSet result;
        PreparedStatement statement = null;
        Connection connection = getConnection();
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Exception at execute query:Database " + e.getLocalizedMessage());
            return null;
        } finally {

        }
        return result;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("Isbn"));
//        colAvgRating.setCellValueFactory(new PropertyValueFactory<>("Average Rating"));
    }
}