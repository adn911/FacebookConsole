package org.consolefacebook.services;

import org.consolefacebook.dao.PostDAO;
import org.consolefacebook.dao.PostDAOImpl;
import org.consolefacebook.models.Post;
import org.consolefacebook.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class PostServiceImpl implements PostService {

    PostDAO postDAO;

    public PostServiceImpl() {

        postDAO = new PostDAOImpl();
    }

    @Override
    public boolean createNewPost(int userId, int type, String content, String dateTime) {

       return postDAO.createNewPost(userId,type,content,dateTime);
    }

    @Override
    public boolean updatePost(int postId, int type, String content,String dateTime) {

     return postDAO.updatePost(postId,type,content,dateTime);

    }

    @Override
    public Post getPost(int postId) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {

        return postDAO.getAllPosts();
    }


    @Override
    public List<Post> getNewsFeedPosts(int currentUserId) {

       return postDAO.getNewsFeedPosts(currentUserId);
    }

    @Override
    public List<Post> getUserPosts(int userId) {

       return postDAO.getUserPosts(userId);
    }

    @Override
    public boolean removeAll() {
       return postDAO.removeAll();
    }

    @Override
    public boolean removePost(int postId) {
      return postDAO.removePost(postId);
    }
}
