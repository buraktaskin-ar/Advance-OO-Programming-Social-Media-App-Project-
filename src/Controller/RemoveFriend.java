/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.Alert;
import java.sql.SQLException;
import Model.Database;
import Model.User;
/**
 *
 * @author grapl
 */
public class RemoveFriend {
    private User user,f;
    private Database database;
    
    public RemoveFriend(User user, Database database, User f){
        this.user = user;
        this.f = f;
        this.database = database;
        
    
    }
    
    public boolean isRemoved(){
    
        boolean removed = false;
        String delete = "DELETE FROM friends WHERE User = "+user.getID()+" AND Friend = "+f.getID()+" ";
        try {
            database.getStatement().execute(delete);
            removed = true;
        }catch (SQLException e){
            new Alert(e.getMessage(), null);
            removed = false;
            
        }
        return removed;
    }
}
