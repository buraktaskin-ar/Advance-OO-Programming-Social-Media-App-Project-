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

public class CreateGroup {
    private User u;
    private Database database;
    private Group g;
    
     public CreateGroup(Group g, Database database,User mainUser){
        this.g = g;
        this.database = database;
        this.u = mainUser;
    }
    
    public void create(){
        
    String insert = "INSERT INTO groups (Name) VALUES ('" 
                    + g.getName() + "')" ;        
        try{
            database.getStatement().execute(insert);
            new Alert("New Group is Created!",null);
        }
        catch(SQLException e){
            new Alert(e.getMessage(), null);
            System.out.println(e.getMessage());
        }
    }
    
}
