/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.Group;
import java.util.ArrayList;
import View.Alert;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author grapl
 */
public class ReadAllGroups {
    private ArrayList<Group> groups;
    public ReadAllGroups(Database database){
        String select = "SELECT * FROM groups";
        groups = new ArrayList<>();
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                Group g = new Group();
                g.setGID(rs.getInt("GID"));
                g.setName(rs.getString("Name"));
                groups.add(g);
            }
        }catch (SQLException e){
            new Alert(e.getMessage(), null);
        }
    
    }

    public ArrayList<Group> getList() {
        return groups;    
    }
}
