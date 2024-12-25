/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Database;
import Model.Post;
import View.Alert;
import java.sql.SQLException;
/**
 *
 * @author grapl
 */
public class CreatePost {
    
    private Post post;
    private Database database;
    
    public CreatePost(Post post, Database database){
        this.post = post;
        this.database = database;
    }
    
    public boolean posted(){
        boolean posted = false;
        try {
            String insert = "INSERT INTO `posts`(`Content`, `User`, `DateTime`) VALUES ('"+post.getContent()+"','"+post.getUser().getID()+"','"+post.getDateTimeToString()+"')";
            database.getStatement().execute(insert);
            posted = true;
        } catch(SQLException e){
            new Alert(e.getMessage(), null);
            posted = false;
        }
        return posted;
    }
}
