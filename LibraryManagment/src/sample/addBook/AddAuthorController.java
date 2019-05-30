package sample.addBook;

import Connection.DbConnector;
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

public class AddAuthorController {
    public AnchorPane rootPane;
    public TextField txtAuthorName;
    public TextArea txtAboutAuthor;

    public void addAuthor(ActionEvent actionEvent) {
        DbConnector connector = new DbConnector();
        String authorsName = txtAuthorName.getText();
        String aboutAuthor = txtAboutAuthor.getText();
        String getAuthor = "SELECT * FROM Authors WHERE Name = '" + txtAuthorName.getText() + "'";
        ResultSet rs;


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
                state = conn.prepareStatement(getAuthor);
                rs = state.executeQuery(getAuthor);
                if (rs.isBeforeFirst()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("This Author already exist");
                    alert.showAndWait();
                    return;
                }
                state = conn.prepareStatement(sql);
                state.setString(1, authorsName);
                state.setString(2, aboutAuthor);
                //state.setString(1, textField.getText());
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

    public void returnToHome(ActionEvent actionEvent) throws IOException {
        Parent blah = FXMLLoader.load(getClass().getClassLoader().getResource("sample/addBook/Add.fxml"));
        rootPane.getChildren().setAll(blah);
    }
}
