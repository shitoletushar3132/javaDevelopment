import java.sql.Connection;
import java.sql.DriverManager;


public class Database {

    public static void main(String [] a){
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password="3132";

        String query = "SELECT * FROM users";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,username,password);

            System.out.println("Connection Successful");
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
