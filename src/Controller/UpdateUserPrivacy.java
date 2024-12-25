/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.Database;
import View.Alert;
import java.sql.SQLException;
/**
 *
 * @author grapl
 */
public class UpdateUserPrivacy {
    public UpdateUserPrivacy (User u, Database database,String t){
        String updateQuery = "UPDATE users SET privacyEnabled = '"+t+"' WHERE ID = '"+u.getID()+"'";
        
        try {
            database.getStatement().executeUpdate(updateQuery);
            
            
        } catch (SQLException e){
            new Alert(e.getMessage(), null);
        }
        
    }
}
