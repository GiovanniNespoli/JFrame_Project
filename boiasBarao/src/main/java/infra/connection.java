package infra;

import java.sql.*;

public class connection {

    private static Connection conexao_MySql = null;
    // local onde o banco de dados está presente. Por padrão, colocarei localhost, 
    //mas você pode mudar o local de acordo com sua necessidade.
    private static String localBD = "localhost";

    // Aqui são os LINKS responsáveis pelo local onde o BD estar. é modificável 
    //de acordo com suas necessidades
    private static String LINK = "jdbc:mysql://" + localBD + ":3306/pauladocessabores";

    // tem essas alternativas do formato do link caso vc queira usar.
    //private static String LINK1 = "jdbc:mysql://localhost:3306/coloque o nome do bd";
    // Nome do usuário e senha com permissão de acesso ao BD. Você coloque de acordo com o
    // usuário e senha pertencente ao Banco de Dados
    private static final String usuario = "root";
    private static final String senha = "Senai123";

    public Connection connectionMySql() {
        try {
            //define o caminho para a conexão
            conexao_MySql = DriverManager.getConnection(LINK, usuario, senha);
            //se der tudo certo
            System.out.println("conexão OK!");
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um problema na conexão com o BD", e);
        }
        return conexao_MySql;
    }

    public boolean findUser(Connection con, String email, String password) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE name = \"" + email + "\" AND password = \"" + password + "\";");

            if (rs != null) {
                System.out.println("foi");
                return true;
            }

            return false;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void createUser(Connection con, String name, String email, String password) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO User (name,email,password) VALUES(\"" + name + "\",\"" + email + "\",\"" + password + "\");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void closeConnectionMySql(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("Fechamento OK");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um problema para "
                    + "encerrar a conexão com o BD.", e);
        }
    }
}
