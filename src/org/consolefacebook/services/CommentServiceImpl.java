package org.consolefacebook.services;

import org.consolefacebook.dao.CommentDAO;
import org.consolefacebook.dao.CommentDAOImpl;
import org.consolefacebook.models.Comment;
import org.consolefacebook.models.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class CommentServiceImpl implements CommentService {

    private CommentDAO commentDAO;

    public CommentServiceImpl() {
        this.commentDAO = new CommentDAOImpl();
    }

    @Override
    public boolean createNewComment(int postId, int userId, String content, String dateTime) {

        return commentDAO.createNewComment(postId,userId,content,dateTime);
    }

    @Override
    public boolean updateComment(int commentId, String content,String dateTime) {

      return commentDAO.updateComment(commentId,content,dateTime);

    }


    @Override
    public List<Comment> getPostComments(int postId) {

       return commentDAO.getPostComments(postId);
    }

    @Override
    public List<Comment> getUserComments(int userId) {

        return commentDAO.getUserComments(userId);


    }

    @Override
    public boolean removeAll() {

      return commentDAO.removeAll();
    }

    @Override
    public boolean removeComment(int commentId) {

       return commentDAO.removeComment(commentId);
    }
}
