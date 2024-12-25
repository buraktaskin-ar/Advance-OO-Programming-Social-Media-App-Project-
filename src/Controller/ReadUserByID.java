/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.User;
import View.Alert;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author grapl
 */
public class ReadUserByID {
    
    private User user;
    public ReadUserByID(int ID, Database database){
        String select = "SELECT * FROM users WHERE ID = "+ID+"";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            rs.next();
            user = new User();
            user.setID(ID);
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            user.setEmail(rs.getString("Email"));
            if("false".equals(rs.getString("privacyEnabled"))){
                    user.setprivacyEnabled(false);
                    
                }
            else {
                user.setprivacyEnabled(true);
            }
            }catch(SQLException e){
                new Alert(e.getMessage(), null);
            }

    }
    
    public User getUser(){
        return user;
    
    }
}
