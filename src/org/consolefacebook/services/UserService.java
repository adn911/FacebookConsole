package org.consolefacebook.services;

import org.consolefacebook.models.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface UserService {

    public User loginUser(String email,String password);
    public boolean createNewUser(String username, String email, String password, String firstName, String lastName, String DOB);
    public boolean updateUser(int userId,String username, String email, String password, String firstName, String lastName, String DOB);

    public List<User> getAllUsers();
    public User getUserInfo(int userId);


    public boolean deactivateUser(int userId);
    public boolean removeUser(int userId);
    public boolean removeAll();
}
