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
import java.util.ArrayList;

public class ReadUser {
    private boolean loggedIn;
    private User user;
    public ReadUser(String email,String password, Database database){
        String select =  "SELECT * FROM users WHERE Email = '"+email+"' AND Password = '"+password+"'";
    
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            loggedIn = rs.next();
            if(loggedIn){
                user = new User();
                user.setID(rs.getInt("ID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                if("0".equals(rs.getString("privacyEnabled"))){
                    user.setprivacyEnabled(false);
                    
                }
                else {
                    user.setprivacyEnabled(true);
                }
                
                if("false".equals(rs.getString("privacyEnabled"))){
                    user.setprivacyEnabled(false);
                    
                }
                else {
                    user.setprivacyEnabled(true);
                }
                String findFriends = "SELECT * FROM friends WHERE User = "+user.getID()+"";
                ResultSet rs2 = database.getStatement().executeQuery(findFriends);
                ArrayList<Integer> friendsIDs = new ArrayList<>();
                while (rs2.next()){
                    friendsIDs.add(rs2.getInt("Friend"));
                }
                user.setFriendsIDs(friendsIDs);
            }
            
        }catch(SQLException e){
            new Alert(e.getMessage(), null);
        }
    }
    public boolean loggedIn(){
        return loggedIn;
    }
    
    public User getUser(){
        return user;
    }
}
