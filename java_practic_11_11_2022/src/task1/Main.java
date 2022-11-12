package task1;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver"); // com.mysql.jdbc.Driver
            String url = "jdbc:postgresql://localhost:5432/curator";
            String login = "postgres";
            String password = "12345";
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement ps = connection.prepareStatement("update curator_inspection_plan set name = ? where name = ?");
            ps.setString(1, "Test_again3");
            ps.setString(2, "Test_again2");
            ps.executeUpdate();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from curator_inspection_plan");
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println(id + " " + name);
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
