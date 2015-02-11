package org.consolefacebook.services;

import org.consolefacebook.dao.UserDAO;
import org.consolefacebook.dao.UserDAOImpl;
import org.consolefacebook.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public User loginUser(String loginEmail, String loginPassword) {

        return userDAO.loginUser(loginEmail, loginPassword);
    }

    @Override
    public boolean createNewUser(String username, String email, String password, String firstName, String lastName, String DOB) {

      return userDAO.createNewUser(username, email,password,firstName,lastName,DOB);
    }

    @Override
    public boolean updateUser(int userId, String username, String email, String password, String firstName, String lastName, String DOB) {

      return userDAO.updateUser(userId,username,email,password,firstName,lastName,DOB);
    }

    @Override
    public boolean removeUser(int userId) {

        return userDAO.removeUser(userId);
    }



    @Override
    public boolean deactivateUser(int userId)
    {
        return userDAO.deactivateUser(userId);
    }

    @Override
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }



    @Override
    public User getUserInfo(int userId) {

       return userDAO.getUserInfo(userId);
    }

    @Override
    public boolean removeAll() {

       return userDAO.removeAll();
    }
}
