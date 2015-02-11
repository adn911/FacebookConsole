package org.consolefacebook.dao;

import org.consolefacebook.models.Comment;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface CommentDAO {

    public boolean createNewComment(int postId, int userId, String content, String dateTime);
    public boolean updateComment(int commentId, String content, String dateTime);

    public List<Comment> getPostComments(int postId);
    public List<Comment>  getUserComments(int userId);
    public boolean removeAll();
    public boolean removeComment(int commentId);

}
