
package Model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;


public class Database {
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3308/socialmedia";
    private Statement statement;
    
    public Database(){
        try {
        
            Connection connection = DriverManager.getConnection(url,user,pass);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    
    }
    public Statement getStatement(){
        return statement;
    }
}
