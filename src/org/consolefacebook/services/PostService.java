package org.consolefacebook.services;

import org.consolefacebook.models.Post;
import org.consolefacebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface PostService {

    public boolean createNewPost(int userId, int type, String content, String dateTime);
    public boolean updatePost(int postId, int type, String content,String dateTime);

    public Post  getPost(int postId);
    public List<Post> getAllPosts();
    public List<Post> getNewsFeedPosts(int currentUserId);
    public List<Post>  getUserPosts(int userId);
    public boolean removeAll();
    public boolean removePost(int postId);

}
