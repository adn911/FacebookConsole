package org.consolefacebook.dao;

import org.consolefacebook.mappers.LikeRowMapper;
import org.consolefacebook.models.Like;
import org.consolefacebook.models.User;
import org.consolefacebook.util.DatabaseTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GALIB on 2/8/2015.
 */
public class LikeDAOImpl implements LikeDAO {

    //private DataAccess dataAccess;

    public LikeDAOImpl() {
      //  this.dataAccess = new DataAccess();
    }

    @Override
    public boolean addLike(int userId, int postId, String dateTime, boolean active) {

        String sql = "INSERT INTO likes (POST_ID,USER_ID,ACTIVE,DATETIME) VALUES (?,?,?,?)";
        return DatabaseTemplate.executeQuery(sql, postId, userId, active, dateTime);
    }

    @Override
    public boolean removeLike(int likeId) {

        String sql = "UPDATE likes SET active = 0 WHERE LIKE_ID =?";
        return DatabaseTemplate.executeQuery(sql, likeId);
    }

    @Override
    public List<User> getLikedUsers(int postId) {

        List<User> likedUsers = new ArrayList<User>();

        UserDAO userDAO = new UserDAOImpl();

        String sql = "SELECT * FROM likes WHERE POST_ID =?";

        List<Like> likes = DatabaseTemplate.queryForObject(sql,new LikeRowMapper(),postId);

        for(Like like:likes){

            int userId = like.getUserId();
            likedUsers.add(userDAO.getUserInfo(userId));
        }

        return likedUsers;
    }

    @Override
    public int getLikeCount(int postId) {

        String sql = "SELECT * FROM likes WHERE POST_ID =?";

        List<Like> likes = DatabaseTemplate.queryForObject(sql,new LikeRowMapper(),postId);

        return likes.size();
    }
}
