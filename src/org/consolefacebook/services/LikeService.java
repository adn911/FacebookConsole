package org.consolefacebook.services;

import org.consolefacebook.models.Post;
import org.consolefacebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface LikeService {

    public boolean addLike(int userId, int postId,String dateTime,boolean active);
    public boolean removeLike(int likeId);
    public List<User> getLikedUsers(int postId);
    public int getLikeCount(int postId);

}
