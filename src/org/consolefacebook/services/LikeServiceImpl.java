package org.consolefacebook.services;

import org.consolefacebook.dao.LikeDAO;
import org.consolefacebook.dao.LikeDAOImpl;
import org.consolefacebook.models.Post;
import org.consolefacebook.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GALIB on 2/8/2015.
 */
public class LikeServiceImpl implements LikeService {

    private LikeDAO likeDAO;

    public LikeServiceImpl() {
        this.likeDAO = new LikeDAOImpl();
    }

    @Override
    public boolean addLike(int userId, int postId, String dateTime, boolean active) {

        return likeDAO.addLike(userId,postId,dateTime,active);
    }

    @Override
    public boolean removeLike(int likeId) {

       return likeDAO.removeLike(likeId);
    }

    @Override
    public List<User> getLikedUsers(int postId) {

       return this.likeDAO.getLikedUsers(postId);
    }

    @Override
    public int getLikeCount(int postId) {

       return this.likeDAO.getLikeCount(postId);
    }
}
