package sample.Home;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entityes.Author;
import entityes.Book;
import entityes.Book_Genre;
import entityes.Genre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static Connection.DbConnector.getConnection;

public class HomeController implements Initializable {
    public TableView<Book> booksTableView;
    public TableColumn colTitle;
    public TableColumn colYear;
    public TableColumn colISBN;
    public TableView<Author> authorsTableView;
    public TableColumn colAuthorName;
    public TableColumn colAboutAuthor;
    public TableView<Genre> genreTableView;
    public TableColumn colGenreTyoe;
    public Pane rootPane;
    public Pane rootPane2;
    public TextField searchText;
    public TextField searchText2;
    public Tab genreTab;
    public TableView<Book_Genre> Book_Genre_TableView;
    //// Book_genre colums
    public TableColumn colTitle2;
    public TableColumn colYear2;
    public TableColumn colIsbn;
    public TableColumn colGenreType;

    @FXML
    private Button btnCheckOutBook;
    @FXML
    private Button btnAddMember;
    @FXML
    private Button btnAddBook;
    @FXML
    private Button btnAddBookCopy;
    @FXML
    private Button btnSignOut;
    @FXML
    private Button btnRecord;
    @FXML
    private Button btnOverdue;
    @FXML
    private Label welcomeLBL;


    public void viewBooksData() {
        ResultSet rs;
        String cquery = "SELECT * FROM BOOKS";
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
                booksTableView.getItems().add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        tableview.getItems().setAll(list);
    }

    public void viewAuthorsData() {
        ResultSet rs;
        String cquery = "SELECT * FROM Authors";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        // rs = execQuery(cquery);
        try {
            statement = connection.prepareStatement(cquery);
            rs = statement.executeQuery(cquery);
            while (rs.next()) {
                String name = rs.getString("name");
                String about = rs.getString("about");

//                double avgRating = rs.getDouble("avg_rating");
//                Book book = new Book(title, year, isbn);
                Author author = new Author(name, about);
                // ObservableList<Book> books = FXCollections.observableArrayList();
                authorsTableView.getItems().add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewGenreData() {
        ResultSet rs;
        String cquery = "SELECT * FROM Genre";
        PreparedStatement statement = null;
        Connection connection = getConnection();
        // rs = execQuery(cquery);
        try {
            statement = connection.prepareStatement(cquery);
            rs = statement.executeQuery(cquery);
            while (rs.next()) {
                String type = rs.getString("GenreType");
//                String about = rs.getString("about");

//                double avgRating = rs.getDouble("avg_rating");
//                Book book = new Book(title, year, isbn);
                Genre genre = new Genre(type);
                // ObservableList<Book> books = FXCollections.observableArrayList();
                genreTableView.getItems().add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


    @FXML
    public void addBook() {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/Add.fxml"));
            rootPane.getChildren().setAll(blah);
//            Scene scene = new Scene(blah);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewBooksData();
        viewAuthorsData();
        viewGenreData();
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("Isbn"));
        colAuthorName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAboutAuthor.setCellValueFactory(new PropertyValueFactory<>("about"));
        colGenreTyoe.setCellValueFactory(new PropertyValueFactory<>("GenreType"));
    }

    public void viewBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/viewBook/ViewBook.fxml"));
            rootPane.getChildren().setAll(blah);
//            Scene scene = new Scene(blah);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/updateBook/Update.fxml"));
            rootPane.getChildren().setAll(blah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteBook(ActionEvent actionEvent) {
        try {
            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/deleteBook/DeleteBook.fxml"));
            rootPane.getChildren().setAll(blah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(ActionEvent actionEvent) {
        if (!searchText.getText().isEmpty() && !searchText2.getText().isEmpty()) {
            String selectBooks = "select title, year, isbn, GenreType\n" +
                    "from books join genre \n" +
                    "on books.GenreId = genre.GenreId\n" +
                    "where books.title = '" + searchText.getText() + "' and genre.GenreType = '" + searchText2.getText() + "'";
            ResultSet rs;
            PreparedStatement statement = null;
            Connection connection = getConnection();
            try {
                statement = connection.prepareStatement(selectBooks);
                rs = statement.executeQuery(selectBooks);
                if (!rs.isBeforeFirst()) {
                    System.out.println("No data");
                }
                while (rs.next()) {
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                    int isbn = rs.getInt("isbn");
                    String genreType = rs.getString("GenreType");
//                double avgRating = rs.getDouble("avg_rating");
                    Book_Genre book_genre = new Book_Genre(title, year, isbn, genreType);
                    // ObservableList<Book> books = FXCollections.observableArrayList();
                    Book_Genre_TableView.getItems().clear();
                    Book_Genre_TableView.getItems().add(book_genre);
                    colTitle2.setCellValueFactory(new PropertyValueFactory<>("Title"));
                    colYear2.setCellValueFactory(new PropertyValueFactory<>("Year"));
                    colIsbn.setCellValueFactory(new PropertyValueFactory<>("Isbn"));
                    colGenreType.setCellValueFactory(new PropertyValueFactory<>("GenreType"));

                }
                System.out.println("exited");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (searchText.getText().equals("") == false) {
            String selectBooks = "Select * from books where title like'%" + searchText.getText() + "%'"
                    + "Union Select * from books where year like'%" + searchText.getText() + "%'"
                    + "Union Select * from books where isbn like'%" + searchText.getText() + "%'";
            String selectAuthors = "Select * from Authors where name like'%" + searchText.getText() + "%'"
                    + "Union Select * from Authors where about like'%" + searchText.getText() + "%'";
            ResultSet rs;
            ResultSet rs2;
            ResultSet rs3;
            PreparedStatement statement = null;
            Connection connection = getConnection();
            // rs = execQuery(cquery);
            try {
                statement = connection.prepareStatement(selectBooks);
                rs = statement.executeQuery(selectBooks);
                while (rs.next()) {
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                    int isbn = rs.getInt("isbn");
//                double avgRating = rs.getDouble("avg_rating");
                    Book book = new Book(title, year, isbn);
                    // ObservableList<Book> books = FXCollections.observableArrayList();
                    booksTableView.getItems().clear();
                    booksTableView.getItems().add(book);
                    colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
                    colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
                    colISBN.setCellValueFactory(new PropertyValueFactory<>("Isbn"));
                    colAuthorName.setCellValueFactory(new PropertyValueFactory<>("name"));
                    colAboutAuthor.setCellValueFactory(new PropertyValueFactory<>("about"));
                    colGenreTyoe.setCellValueFactory(new PropertyValueFactory<>("GenreType"));
                    System.out.println("exited2222");

                }
                /// SELECT AUTHORS
                statement = connection.prepareStatement(selectAuthors);
                rs2 = statement.executeQuery(selectAuthors);
                while (rs2.next()) {
                    String name = rs2.getString("name");
                    String about = rs2.getString("about");

//                double avgRating = rs.getDouble("avg_rating");
                    Author author = new Author(name, about);
                    // ObservableList<Book> books = FXCollections.observableArrayList();
                    authorsTableView.getItems().clear();
                    authorsTableView.getItems().add(author);
                    colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
                    colYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
                    colISBN.setCellValueFactory(new PropertyValueFactory<>("Isbn"));
                    colAuthorName.setCellValueFactory(new PropertyValueFactory<>("name"));
                    colAboutAuthor.setCellValueFactory(new PropertyValueFactory<>("about"));
                    colGenreTyoe.setCellValueFactory(new PropertyValueFactory<>("GenreType"));
                }
                System.out.println("exited");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}

//    public void search_in_lib(ActionEvent actionEvent) {
//        if(searchText.getText().equals("")){
//            try {
//                Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Home/home.fxml"));
//                rootPane.getChildren().setAll(blah);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else{
//            String  selectBooks  = "Select * from books where title like'%" + searchText.getText() +"%'"
//                    + "Union Select * from books where year like'%" + searchText.getText() +"%'"
//                    + "Union Select * from books where isbn like'%" + searchText.getText() +"%'";
//            ResultSet rs;
//            PreparedStatement statement = null;
//            Connection connection = getConnection();
//            // rs = execQuery(cquery);
//            try {
//                statement = connection.prepareStatement(selectBooks);
//                rs = statement.executeQuery(selectBooks);
//                while (rs.next()) {
//                    String title = rs.getString("title");
//                    int year = rs.getInt("year");
//                    int isbn = rs.getInt("isbn");
////                double avgRating = rs.getDouble("avg_rating");
//                    Book book = new Book(title, year, isbn);
//                    // ObservableList<Book> books = FXCollections.observableArrayList();
//                    booksTableView.getItems().add(book);
//
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }

//    public void SearchinLib(ActionEvent actionEvent) {
//        try {
//            Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Search_In_Library/Search.fxml"));
//           // rootPane2.getChildren().setAll(blah);
//                        Scene scene = new Scene(blah);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



