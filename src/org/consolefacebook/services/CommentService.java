package org.consolefacebook.services;

import org.consolefacebook.models.Comment;
import org.consolefacebook.models.Post;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface CommentService {

    public boolean createNewComment(int postId, int userId, String content, String dateTime);
    public boolean updateComment(int commentId, String content, String dateTime);

    public List<Comment> getPostComments(int postId);
    public List<Comment>  getUserComments(int userId);
    public boolean removeAll();
    public boolean removeComment(int commentId);

}
