/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Database;
import Model.Group;
import Model.User;
import java.util.ArrayList;
import View.Alert;
import java.sql.SQLException;
import java.sql.ResultSet;
public class ReadAllGroupMembers {
    private ArrayList<User> members;
    
    public ReadAllGroupMembers(Database database, Group group){
        String select = "SELECT * FROM groupsmembers WHERE GID = '"+group.getGID()+"'";
        
        members = new ArrayList<>();
        try {
            ArrayList<Integer> ids = new ArrayList<>();
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                int id = rs.getInt("UID");
                ids.add(id);
            }
            
            for (int id: ids){
                User u = new User();
                ReadUserByID rd = new ReadUserByID(id,database);
                u = rd.getUser();
                members.add(u);
            
            }
            
        }catch (SQLException e){
                        System.out.println(e.getMessage());
            new Alert(e.getMessage(), null);
        }
        
    
    }
    
    public ArrayList<User> getList() {
        return members;    
    }
}
