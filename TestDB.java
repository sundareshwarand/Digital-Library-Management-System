import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root",
                    "root123"
                );

            System.out.println("Connected!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}