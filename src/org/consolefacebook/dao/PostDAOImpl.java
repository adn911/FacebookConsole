package org.consolefacebook.dao;

import org.consolefacebook.mappers.PostRowMapper;
import org.consolefacebook.models.Post;
import org.consolefacebook.util.DatabaseTemplate;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class PostDAOImpl implements PostDAO {

   // private DataAccess dataAccess;

    public PostDAOImpl() {
     //   this.dataAccess = new DataAccess();
    }

    @Override
    public boolean createNewPost(int userId, int type, String content, String dateTime) {

        String sql = "INSERT INTO posts (USER_ID,POST_TYPE,CONTENT,DATETIME) VALUES (?,?,?,?)";

        return DatabaseTemplate.executeQuery(sql, userId, type, content, dateTime);
    }

    @Override
    public boolean updatePost(int postId, int type, String content,String dateTime) {

        String sql = "UPDATE posts SET POST_TYPE =?, CONTENT =?, DATETIME =? WHERE POST_ID =?";
        return DatabaseTemplate.executeQuery(sql, type, content, dateTime, postId);

    }

    @Override
    public Post getPost(int postId) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {

        String sql = "SELECT * FROM posts";

        List<Post> posts = DatabaseTemplate.queryForObject(sql,new PostRowMapper());

        return posts;

    }


    @Override
    public List<Post> getNewsFeedPosts(int currentUserId) {

        String sql = "SELECT * FROM posts WHERE USER_ID IN (SELECT FRIEND_ID FROM friends WHERE USER_ID =? ) OR USER_ID =? ";

        List<Post> posts = DatabaseTemplate.queryForObject(sql,new PostRowMapper(),currentUserId,currentUserId);

        return posts;
    }

    @Override
    public List<Post> getUserPosts(int userId) {

        String sql = "SELECT * FROM posts WHERE USER_ID =?";

        List<Post> posts = DatabaseTemplate.queryForObject(sql, new PostRowMapper(), userId);

        return posts;
    }

    @Override
    public boolean removeAll() {
        String sql = "DELETE FROM posts";
        return DatabaseTemplate.executeQuery(sql);
    }

    @Override
    public boolean removePost(int postId) {
        String sql = "DELETE FROM posts WHERE POST_ID =?";
        return DatabaseTemplate.executeQuery(sql,postId);
    }
}
