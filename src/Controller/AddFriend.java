/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.User;
import View.Alert;
import java.sql.SQLException;
/**
 *
 * @author grapl
 */
public class AddFriend {
    
    private User user,f;
    private Database database;
    
    public AddFriend(User user,Database database,User f){
        this.user= user;
        this.database = database;
        this.f = f;
    
    }
    
    public boolean isAdded(){
        boolean added = false;
        String insert ="INSERT INTO friends(`User`, `Friend`) VALUES ('"+user.getID()+"','"+f.getID()+"')";

        try {
        database.getStatement().execute(insert);
        added = true;
        } catch (SQLException e){
            new Alert(e.getMessage(), null);
            added = false;
            
        }
        return added;
    }
    
}
