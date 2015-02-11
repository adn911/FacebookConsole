package org.consolefacebook.dao;

import org.consolefacebook.mappers.UserRowMapper;
import org.consolefacebook.models.User;
import org.consolefacebook.util.DatabaseTemplate;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class FriendDAOImpl implements FriendDAO {

  //  private DataAccess dataAccess;
    private UserDAO userDAO;

    public FriendDAOImpl() {
    //    this.dataAccess = new DataAccess();
        userDAO = new UserDAOImpl();
    }

    public List<User> getUsersNotFriend(int userId) {

        String sql = "SELECT * FROM users WHERE USER_ID !=?"
                +" AND USER_ID NOT IN (SELECT FRIEND_ID from friends WHERE USER_ID =?)";

        List<User> users = DatabaseTemplate.queryForObject(sql,new UserRowMapper(),userId,userId);

        return users;
    }

    @Override
    public List<User> getFriends(int userId) {

        String sql = "SELECT * FROM users WHERE " +
                "USER_ID IN (SELECT FRIEND_ID FROM friends WHERE USER_ID =?) " +
                "AND USER_ID !=?";

        List<User> friends = DatabaseTemplate.queryForObject(sql, new UserRowMapper(), userId, userId);

        return friends;
    }

    @Override
    public boolean addFriend(int userId, int friendId) {

        boolean value = false;

        if(userDAO.getUserInfo(userId)!=null && userDAO.getUserInfo(friendId)!= null){

            String sql1 = "INSERT INTO friends (USER_ID,FRIEND_ID) VALUES (?,?)";

            String sql2 = "INSERT INTO friends (USER_ID,FRIEND_ID) VALUES (?,?)";

            value = DatabaseTemplate.executeQuery(sql1, userId, friendId);
            value = DatabaseTemplate.executeQuery(sql2, friendId, userId);


        }

        return value;
    }

    @Override
    public boolean removeFriend(int userId,int friendId) {

        String sql = "DELETE FROM friends WHERE " +
                "( USER_ID =? AND FRIEND_ID =?) " +
                "OR ( USER_ID =? AND FRIEND_ID =? )";

        return DatabaseTemplate.executeQuery(sql, userId, friendId, friendId, userId);
    }

}
