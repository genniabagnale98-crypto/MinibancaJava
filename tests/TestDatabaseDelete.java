import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class TestDatabaseDelete {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/minibanca";
        String username = "root";
        String password = "mysql_password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connessione riuscita!");

            
            int id = 10;
            
            String sql = "DELETE FROM utenti WHERE id = ?";


            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            int righeModificate = stmt.executeUpdate();
            

            System.out.println("Eliminato correttamente!");

            if (righeModificate> 0) {
            System.out.println("Righe elminate:" + righeModificate); }
            else System.out.println("Id non trovato!");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Errore:");
            e.printStackTrace();
        }
    }
}