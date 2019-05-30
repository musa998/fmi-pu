package sample.addBook;

import Connection.DbConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Home.HomeController;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Connection.DbConnector.getConnection;

public class AddBookController implements Initializable {

    public TextArea txtGenre;
    public Pane rootPane;
    public ComboBox genreComboBox;
    public ComboBox authorComboBox;
    ArrayList<Integer> isbnList = new ArrayList<>();
    ArrayList<String> bookTitleList = new ArrayList<>();
    public TextField authorName;
    public TextField txtPublishYear;
    public TextField txtRating;
    public TextArea txtAboutAuthor;
    public TextField txtTitle;
    public TextField txtISBN;


//    public void addAuthor(ActionEvent actionEvent) {
//        DbConnector connector = new DbConnector();
//        String authorsName = authorName.getText();
//        String aboutAuthor = txtAboutAuthor.getText();
//
//
//        if (authorsName.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("Please Enter All the Fields ");
//            alert.showAndWait();
//        } else {
//
//            String sql = "INSERT INTO authors " +
//                    "VALUES (NULL,?,?)";
//            Connection conn = getConnection();
//            PreparedStatement state = null;
//
//            try {
//                state = conn.prepareStatement(sql);
//                state.setString(1, authorsName);
//                state.setString(2, aboutAuthor);
//                //state.setString(1, textField.getText());
//                state.execute();
//                //MyFrame.this.table.setModel(DBConnector.getAllModel());
//            } catch (SQLException var17) {
//                var17.printStackTrace();
//            } finally {
//                try {
//                    state.close();
//                    conn.close();
//                } catch (SQLException var16) {
//                    var16.printStackTrace();
//                }
//            }
//        }
//    }

    public void addBook(ActionEvent actionEvent) throws SQLException {
        //DbConnector connector = (DbConnector) getConnection();
        String title = txtTitle.getText();
        int bookYear = 0;
//        String genre = txtGenre.getText();
        double avgRating = 0;
        int genreid = 0;
        int  authorId = 0;
        int bookId = 0;

        try {
            bookYear = Integer.parseInt(txtPublishYear.getText());
            avgRating = Double.parseDouble(txtRating.getText());
        } catch (Exception e) {

        }
        int bookIsbn = Integer.parseInt(txtISBN.getText());

        PreparedStatement state = null;
        //Connection connection =  getConnection();
        //  checkBooks(state, conn, title);

        if (txtTitle.getText().isEmpty()
                || authorComboBox.getSelectionModel().getSelectedItem().equals(null)
                || genreComboBox.getSelectionModel().getSelectedItem().equals(null)
                || isbnList.contains(bookIsbn)
                || bookTitleList.contains(title)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter All the Fields or change their value");
            alert.showAndWait();
        } else {
            bookTitleList.add(title);
            isbnList.add(bookIsbn);
            String sql = "INSERT INTO books " +
                    "VALUES (NULL,?,?,?,?)";

            String sql2 = "INSERT INTO Genre " +
                    "VALUES (NULL,?)";

            String sql4 = "INSERT INTO authors " +
                    "VALUES (NULL,?,?)";

            String sql5 = "INSERT INTO books_authors " +
                    "VALUES (?,?)";

            String getAuthor = "SELECT * FROM Authors WHERE Name = '" + authorComboBox.getSelectionModel().getSelectedItem() + "'";

            String getBook = "SELECT * FROM Books WHERE isbn = '" + bookIsbn + "'";

            String getBook2 = "SELECT * FROM Books WHERE title = '" + title + "'";

            System.out.println(genreComboBox.getSelectionModel());

            String cquery = "SELECT * FROM GENRE WHERE GenreType = '" + genreComboBox.getSelectionModel().getSelectedItem() + "'";

            ResultSet rs;
            Connection conn = getConnection();

            try {
                /// Check if genre we want to add already exist
                state = conn.prepareStatement(getBook2);
                rs = state.executeQuery(getBook2);
                if (rs.isBeforeFirst()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("This Author already exist");
                    alert.showAndWait();
                    return;
                }

                state = conn.prepareStatement(cquery);
                rs = state.executeQuery(cquery);

                if (!rs.isBeforeFirst()) {
                    System.out.println("No data");

                    /// Adding genre parameters in the database
//                    state = conn.prepareStatement(sql2);
////                    state.setString(1, genre);
//                    state.execute();
                    /// Extraxcting genre id from database because it is needed for adding it into book record
                    state = conn.prepareStatement(cquery);
                    rs = state.executeQuery(cquery);

                    while (rs.next()) {
                        genreid = Integer.parseInt(rs.getString("GenreId"));
                    }
                }
                while (rs.next()) {
                    genreid = Integer.parseInt(rs.getString("GenreId"));
                }

                // Adding Book parameters in the database
                state = conn.prepareStatement(sql);
                state.setString(1, title);
                state.setInt(2, bookYear);
                state.setInt(3, bookIsbn);
                state.setInt(4, genreid);
                //state.setString(1, textField.getText());
                state.execute();

                /// Adding author for the book
                state = conn.prepareStatement(getAuthor);
                rs = state.executeQuery(getAuthor);
                if (!rs.isBeforeFirst()) {
                    System.out.println("No data");
                    state = conn.prepareStatement(sql4);
                    state.setString(1, authorName.getText());
                    state.setString(2, txtAboutAuthor.getText());
                    //state.setString(1, textField.getText());
                    state.execute();
                }
                state = conn.prepareStatement(getAuthor);
                rs = state.executeQuery(getAuthor);
                /// Adding Records to the third table and creating MANY TO MANY Relationship
                while (rs.next()) {
                    authorId = Integer.parseInt(rs.getString("authorId"));
                }
                state = conn.prepareStatement(getBook);
                rs = state.executeQuery(getBook);
                while (rs.next()) {
                    bookId = Integer.parseInt(rs.getString("bookId"));
                }
                state = conn.prepareStatement(sql5);
                state.setInt(1, bookId);
                state.setInt(2, authorId);
                state.execute();


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Succesfully added");
                alert.showAndWait();


                //MyFrame.this.table.setModel(DBConnector.getAllModel());
            } catch (SQLException var17) {
                var17.printStackTrace();
            } finally {
                try {
                    state.close();
                    conn.close();
//                    HomeController homeController = new HomeController();
//                    homeController.viewBooksData();
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }
        }
    }

    private void checkBooks(PreparedStatement stmt, Connection conn, String titile) throws SQLException {
        ResultSet title;
        String cquery = "SELECT * FROM BOOKS WHERE TITLE = '" + titile + "'";
        conn = getConnection();
        ResultSet rs = stmt.executeQuery(cquery);
        if (rs.next()) {
            System.out.println("Succes");
        } else {
            System.out.println("Eror");
        }

    }

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/Add.fxml"));
        rootPane.getChildren().setAll(blah);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ResultSet rs;
        PreparedStatement statement = null;
        Connection connection = getConnection();
        ObservableList<String> authorOptions =  FXCollections.observableArrayList();
        ObservableList<String> genreOptions =  FXCollections.observableArrayList();

        String authorQuery  = "SELECT NAME FROM Authors";
        String genreQuery  = "SELECT GenreType FROM Genre";

        try {
            statement = connection.prepareStatement(authorQuery);
            rs = statement.executeQuery(authorQuery);
            while (rs.next()){
                authorOptions.add(rs.getString("name"));
            }
            statement = connection.prepareStatement(genreQuery);
            rs = statement.executeQuery(genreQuery);
            while (rs.next()){
                genreOptions.add(rs.getString("GenreType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        authorComboBox.setItems(authorOptions);
        authorComboBox.getSelectionModel().selectFirst();
        genreComboBox.setItems(genreOptions);
        genreComboBox.getSelectionModel().selectFirst();
//        System.out.println(authorComboBox.getSelectionModel().isSelected(0));
//        System.out.println(authorComboBox.getSelectionModel().getSelectedIndex());
        System.out.println(authorComboBox.getSelectionModel().getSelectedItem());
    }
}
