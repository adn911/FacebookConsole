package org.consolefacebook.dao;

import org.consolefacebook.mappers.CommentRowMapper;
import org.consolefacebook.models.Comment;
import org.consolefacebook.util.DatabaseTemplate;

import java.util.List;


/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class CommentDAOImpl implements CommentDAO {

   // private DataAccess dataAccess;

    public CommentDAOImpl() {
     //   this.dataAccess = new DataAccess();
    }

    @Override
    public boolean createNewComment(int postId, int userId, String content, String dateTime) {

        String sql = "INSERT INTO comments (USER_ID,POST_ID,CONTENT,DATETIME) VALUES (?,?,?,?)";

        return DatabaseTemplate.executeQuery(sql, userId, postId, content, dateTime);
    }

    @Override
    public boolean updateComment(int commentId, String content,String dateTime) {

        String sql = "UPDATE comments SET CONTENT =?,DATETIME =? WHERE COMMENT_ID =?";
        return DatabaseTemplate.executeQuery(sql, content, dateTime, commentId);

    }


    @Override
    public List<Comment> getPostComments(int postId) {

        String sql = "SELECT * FROM comments WHERE POST_ID =?";

        List<Comment> comments= DatabaseTemplate.queryForObject(sql,new CommentRowMapper(),postId);

        return comments;
    }

    @Override
    public List<Comment> getUserComments(int userId) {

        String sql = "SELECT * FROM comments WHERE USER_ID =?";

        List<Comment> comments= DatabaseTemplate.queryForObject(sql, new CommentRowMapper(), userId);

        return comments;


    }

    @Override
    public boolean removeAll() {

        String sql = "DELETE FROM comments";
        return DatabaseTemplate.executeQuery(sql);
    }

    @Override
    public boolean removeComment(int commentId) {

        String sql = "DELETE FROM comments WHERE COMMENT_ID =?";
        return DatabaseTemplate.executeQuery(sql,commentId);
    }
}
