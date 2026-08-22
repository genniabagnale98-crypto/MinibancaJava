import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class TestDatabaseInsert {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/minibanca";
        String username = "root";
        String password = "mysql_password";

        try {
           
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connessione riuscita!");

            String user = "Franco";
            String pass = "0000";
            BigDecimal saldo = new BigDecimal("300.00");

            String sql = "INSERT INTO utenti (username, password, saldo) VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user);
            stmt.setString(2, pass);
            stmt.setBigDecimal(3, saldo);

            stmt.executeUpdate();

            System.out.println("Inserito correttamente!");

            

        } catch (SQLException e) {
            System.out.println("Errore:");
            e.printStackTrace();
        }
    }
}