package sample.deleteBook;

import Connection.DbConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static Connection.DbConnector.getConnection;

public class DeleteBookController implements Initializable {
    public TextField txtSearchTitle;
    public AnchorPane rootPane;
    public ComboBox deleteComboBox;
    private String selectFrom;
    private  String deleteFrom;

    public void deleteBook(ActionEvent actionEvent) {
        ResultSet rs;
        String bookSelectquery = "SELECT * FROM BOOKS WHERE TITLE = '" + txtSearchTitle.getText() + "'";
        String authorSelectQuery = "SELECT * FROM Authors WHERE Name = '" + txtSearchTitle.getText() + "'";
        String deleteBookSql = "Delete FROM BOOKS WHERE TITLE = '" + txtSearchTitle.getText() + "'";
        String deleteAuthorSql = "Delete FROM Authors WHERE Name = '" + txtSearchTitle.getText() + "'";
        String deleteGenreSql = "Delete FROM Genre WHERE GenreType = '" + txtSearchTitle.getText() + "'";


        PreparedStatement statement = null;
        Connection connection = getConnection();

            String entity = deleteComboBox.getValue().toString();

        try {
            chooseEntity(entity,statement, connection,
                    deleteBookSql, deleteAuthorSql,
                    deleteGenreSql);
            statement = connection.prepareStatement(selectFrom);

            rs = statement.executeQuery(selectFrom);
            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Enity not found");
                alert.showAndWait();
            } else {
//                chooseEntity(entity, statement, connection,
////                        deleteBookSql, deleteAuthorSql
////                        ,deleteGenreSql);
                statement = connection.prepareStatement(deleteFrom);
                statement.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Entity deleted");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void chooseEntity(String entity, PreparedStatement statement,
                              Connection connection, String deleteBookSql,
                              String deleteAuthorSql, String deleteGenreSql) throws SQLException {
        switch (entity){
            case "Book by title":
                statement = connection.prepareStatement(deleteBookSql);
                this.selectFrom = "SELECT * FROM BOOKS WHERE TITLE = '" + txtSearchTitle.getText() + "'";
                deleteFrom = "Delete FROM BOOKS WHERE TITLE = '" + txtSearchTitle.getText() + "'";
                break;
            case "Author by name":
                statement = connection.prepareStatement(deleteAuthorSql);
                this.selectFrom = "SELECT * FROM Authors WHERE Name = '" + txtSearchTitle.getText() + "'";
                deleteFrom = "Delete FROM Authors WHERE Name = '" + txtSearchTitle.getText() + "'";
                break;
            case "Genre by type":
                statement = connection.prepareStatement(deleteGenreSql);
                this.selectFrom = "SELECT * FROM Genre WHERE GenreType = '" + txtSearchTitle.getText() + "'";
                deleteFrom = "Delete FROM Genre WHERE GenreType = '" + txtSearchTitle.getText() + "'";
                break;
            default:
                System.out.println("There is no criteria");
                break;
        }

    }

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/home/home.fxml"));
        rootPane.getChildren().setAll(blah);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options =  FXCollections.observableArrayList("Book by title",
                "Author by name", "Genre by type" );
        deleteComboBox.setItems(options);
        deleteComboBox.getSelectionModel().selectFirst();
    }
}
