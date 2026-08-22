import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class TestDatabaseUpdate {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/minibanca";
        String username = "root";
        String password = "mysql_password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connessione riuscita!");

            String user = "JDBC_TEST_2";
            BigDecimal nuovoSaldo = new BigDecimal("1500.00");

            String sql = "UPDATE utenti SET saldo = ? WHERE username = ?";


            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setBigDecimal(1, nuovoSaldo);
            stmt.setString(2, user);

            int righeModificate = stmt.executeUpdate();
            

            System.out.println("Modifica insrita!");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Errore:");
            e.printStackTrace();
        }
    }
}