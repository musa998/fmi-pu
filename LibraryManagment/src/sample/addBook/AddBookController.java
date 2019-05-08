package sample.addBook;

import Connection.DbConnector;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.text.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Connection.DbConnector.conn;
import static Connection.DbConnector.getConnection;

public class AddBookController {

    public TextArea txtGenre;
    ArrayList<Integer> isbnList = new ArrayList<>();
    ArrayList<String> bookTitleList = new ArrayList<>();
    public TextField authorName;
    public TextField txtPublishYear;
    public TextField txtRating;
    public TextArea txtAboutAuthor;
    public TextField txtTitle;
    public TextField txtISBN;


    public void addAuthor(ActionEvent actionEvent) {
        DbConnector connector = new DbConnector();
        String authorsName = authorName.getText();
        String aboutAuthor = txtAboutAuthor.getText();


        if (authorsName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter All the Fields ");
            alert.showAndWait();
        } else {

            String sql = "INSERT INTO authors " +
                    "VALUES (NULL,?,?)";
            Connection conn = getConnection();
            PreparedStatement state = null;

            try {
                state = conn.prepareStatement(sql);
                state.setString(1, authorsName);
                state.setString(2, aboutAuthor);
                //state.setString(1, textField.getText());
                state.execute();
                //MyFrame.this.table.setModel(DBConnector.getAllModel());
            } catch (SQLException var17) {
                var17.printStackTrace();
            } finally {
                try {
                    state.close();
                    conn.close();
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }
        }
    }

    public void addBook(ActionEvent actionEvent) throws SQLException {
      //DbConnector connector = (DbConnector) getConnection();
        String title = txtTitle.getText();
        int bookYear = 0;
        String genre = txtGenre.getText();
        double avgRating=0;

        try {
            bookYear = Integer.parseInt(txtPublishYear.getText());
            avgRating = Double.parseDouble(txtRating.getText());
        }catch (Exception e){

        }
        int bookIsbn = Integer.parseInt(txtISBN.getText());

        PreparedStatement state = null;
        //Connection connection =  getConnection();
      //  checkBooks(state, conn, title);

        if (txtTitle.getText().isEmpty() || txtTitle.getText().isEmpty()
                || authorName.getText().isEmpty() || isbnList.contains(bookIsbn)
                || bookTitleList.contains(title)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter All the Fields or change their value");
            alert.showAndWait();
        } else {
            bookTitleList.add(title);
            isbnList.add(bookIsbn);
            String sql = "INSERT INTO books " +
                    "VALUES (NULL,?,?,?,NULL)";

            String sql2 = "INSERT INTO Genre " +
                    "VALUES (NULL,?)";

            Connection conn = getConnection();


            try {
                state = conn.prepareStatement(sql);
                state.setString(1, title);
                state.setInt(2, bookYear);
                state.setInt(3, bookIsbn);
                //state.setString(1, textField.getText());
                state.execute();
                state = conn.prepareStatement(sql2);
                state.setString(1, genre);
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
                } catch (SQLException var16) {
                    var16.printStackTrace();
                }
            }
        }
    }
    private void checkBooks(PreparedStatement stmt, Connection conn, String titile) throws SQLException {
        ResultSet title;
        String cquery = "SELECT * FROM BOOKS WHERE TITLE = '"+titile+"'";
        conn = getConnection();
        ResultSet rs = stmt.executeQuery(cquery);
        if (rs.next()){
            System.out.println("Succes");
        }
        else {
            System.out.println("Eror");
        }

//        try {
//            while(title.next())
//            {
//                String title1 = title.getString("title");
//                System.out.println(title1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
