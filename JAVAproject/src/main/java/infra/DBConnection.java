package infra;

import java.sql.*;

public class DBConnection {

    private static Connection conexao_MySql = null;

    public Connection connectionMySql() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            conexao_MySql = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectJAVA", "root", "senai123");
            System.out.println("conexão OK!");
        } catch (Exception e) {
            System.out.println(e);
        }

        return conexao_MySql;
    }

    public boolean findUser(Connection con, String email, String password) {
        try {
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM User WHERE email =/" + email + "/AND password =/" + password;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                System.out.println("true");
                return true;
            }

            System.out.println("false");
            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
