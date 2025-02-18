package tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/gestionnaire_contacts";
    private static final String USER = "root";
    private static final String PASSWORD = "Ahmed";

    // Méthode pour établir la connexion
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connexion réussie à la base de données !");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Pilote JDBC introuvable !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Erreur de connexion à la base de données !");
            e.printStackTrace();
        }
        return conn;
    }



}
