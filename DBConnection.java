import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/studentdb",
                    "postgres",
                    "your_password_here"
            );

            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}