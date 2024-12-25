/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.Group;
import Model.User;
import View.Alert;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class JoinGroup {
    private Group group;
    private Database database;
    private User user;
    
    public JoinGroup(Group g, Database database,User user){
        this.group = g;
        this.database = database;
        this.user = user;
    }
    
    public boolean isJoined(){
        boolean joined = false;
        String insert ="INSERT INTO groupsmembers(`GID`, `UID`) VALUES  ("+group.getGID()+", "+user.getID()+")  ";

        try {
        database.getStatement().execute(insert);
        joined = true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            new Alert(e.getMessage(), null);
            joined = false;
            
        }
        return joined;
        
    
    }
    
    public boolean isMember(){
        boolean ismember = false;
        String select ="SELECT * FROM groupsmembers WHERE GID ="+group.getGID()+" AND UID = "+user.getID()+"  ";
        
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            ismember = rs.next();
        
        } catch (SQLException e){
            System.out.println(e.getMessage());
            new Alert(e.getMessage(), null);
            ismember = false;
            
        }
        return ismember;
    }
}
