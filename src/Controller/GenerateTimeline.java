/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.Post;
import Model.User;
import View.Alert;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

public class GenerateTimeline {
    private ArrayList<Post>  posts;
    public GenerateTimeline(User user, Database database){
    
        posts = new ArrayList<>();
        
        
        if (user.getFriendsIDs().isEmpty()) {
        return;
    }
        StringBuilder sb = new StringBuilder();
        if (user.getFriendsIDs().size()!=0){
            for (int i = 0 ; i<user.getFriendsIDs().size();i++){
                sb.append(" User = "+user.getFriendsIDs().get(i));
                if(i!= user.getFriendsIDs().size()-1){
                    sb.append(" OR ");
                }
                else {
                    sb.append(";");
                }
            }
        }
        String select= "SELECT * FROM `posts` WHERE "+sb.toString();
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            ArrayList<Integer> usersIDs = new ArrayList<>();
            
            while (rs.next()){
                Post p = new Post();
                p.setID(rs.getInt("ID"));
                p.setContent(rs.getString("Content"));
                usersIDs.add(rs.getInt("User"));
                p.setDateTimeFromString(rs.getString("DateTime"));
                posts.add(p);
            }
            for (int i=0; i <usersIDs.size(); i++){
                posts.get(i).setUser(new ReadUserByID(usersIDs.get(i),database).getUser());
            }
        
        }catch(SQLException e){
            System.out.printf(e.getMessage());
            new Alert(e.getMessage(), null);
            
        }
    
    }
    
    public GenerateTimeline(User user, Database database,User mainUser){
    
        posts = new ArrayList<>();
        

        String select= "SELECT * FROM `posts` WHERE  User = "+user.getID()+"";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            ArrayList<Integer> usersIDs = new ArrayList<>();
            
            while (rs.next()){
                Post p = new Post();
                p.setID(rs.getInt("ID"));
                p.setContent(rs.getString("Content"));
                usersIDs.add(rs.getInt("User"));
                p.setDateTimeFromString(rs.getString("DateTime"));
                posts.add(p);
            }
            for (int i=0; i <usersIDs.size(); i++){
                posts.get(i).setUser(new ReadUserByID(usersIDs.get(i),database).getUser());
            }
        
        }catch(SQLException e){
            System.out.printf(e.getMessage());
            new Alert(e.getMessage(), null);
            
        }
    
    }
    
    public ArrayList<Post> getPosts(){
    
        return posts;
    }
    
}
