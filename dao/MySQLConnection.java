package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static Connection connection;

    private static final String jdbcURL = "jdbc:mysql://localhost:3306/Bibliobus";
    private static final String username = "Bibliobus";
    private static final String password = "1234";

    // Constructeur privé pour empêcher l'instanciation
    private MySQLConnection() {}

    // Méthode pour obtenir l'instance de connexion
    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connexion réussie !");
        }
        return connection;
    }

    // Méthode pour fermer la connexion (si nécessaire)
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
