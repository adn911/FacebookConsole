package org.consolefacebook.dao;

import org.consolefacebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface FriendDAO {

    public List<User> getFriends(int userId);
    public List<User> getUsersNotFriend(int userId);
    public boolean addFriend(int userId, int friendId);
    public boolean removeFriend(int userId, int friendId);

}
