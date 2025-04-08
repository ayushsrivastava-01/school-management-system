import java.sql.*;
class ConnectionProvider {
    static Connection con=null;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/student";
            String user="root";
            String password="";
            con= DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
