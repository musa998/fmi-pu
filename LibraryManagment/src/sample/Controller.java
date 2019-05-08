package sample;

        import Connection.DbConnector;
        import javafx.event.ActionEvent;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextArea;

        import java.awt.*;
        import java.sql.*;

        import static Connection.DbConnector.getConnection;

public class Controller {

    public Label label;
    public TextArea textField;

    public void Add(ActionEvent actionEvent) throws SQLException {
        DbConnector connector = new DbConnector();
        String name = "botev";
        String about = "botev-books";
        String insertSql = "Insert into genre values(null,name);";
        String sql = "INSERT INTO books " +
                "VALUES (NULL ,?,?,?,?)";
        Connection conn = getConnection();
        PreparedStatement state = null; //= (PreparedStatement) conn.createStatement();
       // state = conn.prepareStatement(insertSql);
        //state.executeUpdate(insertSql);

        try {
            state = conn.prepareStatement(sql);
            state.setString(1, "harry potter");
            state.setInt(2, 2001);
            state.setInt(3, 2929);
            state.setDouble(4, 3.2);
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

    public void select(ActionEvent actionEvent) throws SQLException {
        ResultSet resultSet ;//= statement.executeQuery(selectSql);
        String sql = "select * from authors";
        DbConnector.conn = getConnection();
        try {
            PreparedStatement state = DbConnector.conn.prepareStatement(sql);
            resultSet = state.executeQuery();
            while (resultSet.next()){
                label.setText(resultSet.getString(2));
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }
}
