/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import java.util.ArrayList;
import java.sql.ResultSet;
import Model.User;
import View.Alert;
import java.sql.SQLException;

/**
 *
 * @author grapl
 */
public class ReadAllUsers {
    private ArrayList<User> users;
    
    public ReadAllUsers(Database database, User user){
        String select = "SELECT * FROM users";
        users = new ArrayList<>();
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                User u = new User();
                u.setID(rs.getInt("ID"));
                u.setFirstName(rs.getString("FirstName"));
                u.setLastName(rs.getString("LastName"));
                u.setEmail(rs.getString("Email"));
                if ("true".equals(rs.getString("privacyEnabled"))){
                    continue;
                }
                if (u.getID()!= user.getID()) users.add(u);
            }
        }catch (SQLException e){
            new Alert(e.getMessage(), null);
        }
    
    }

    public ArrayList<User> getList() {
        return users;    
    }
}
