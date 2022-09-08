
import infra.DBConnection;
import java.sql.Connection;


public class testeConnection {
    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        Connection conexao = db.connectionMySql();
        
        String email = "gigio@gmail.com";
        String password = "123";
        
        System.out.println( db.findUser(conexao, email, password));
        
        db.listUser(conexao);
        
    }
}
