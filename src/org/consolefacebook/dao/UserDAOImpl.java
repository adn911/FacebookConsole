package org.consolefacebook.dao;

import org.consolefacebook.mappers.UserRowMapper;
import org.consolefacebook.models.User;
import org.consolefacebook.util.DatabaseTemplate;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class UserDAOImpl implements UserDAO {

    //private DataAccess dataAccess;

    public UserDAOImpl() {
      //  this.dataAccess = new DataAccess();
    }

    @Override
    public User loginUser(String loginEmail, String loginPassword) {

        User user = null;

        String sql = "SELECT * FROM users WHERE EMAIl =? AND PASSWORD =?";

        List<User> users = DatabaseTemplate.queryForObject(sql,new UserRowMapper(),loginEmail,loginPassword);

        return users.size() == 1 ? users.get(0) : null;
    }

    @Override
    public boolean createNewUser(String username, String email, String password, String firstName, String lastName, String DOB) {

        String sql = "INSERT INTO users (USER_NAME,EMAIL,PASSWORD,ACTIVE,FIRST_NAME,LAST_NAME,DOB) VALUES " +
                "(?,?,?,?,?,?,?)";

        return DatabaseTemplate.executeQuery(sql, username, email, password, 1, firstName, lastName, DOB);
    }

    @Override
    public boolean updateUser(int userId, String username, String email, String password, String firstName, String lastName, String DOB) {

       String sql = "UPDATE users SET USER_NAME =?,EMAIL =?,PASSWORD =?,FIRST_NAME=?,LAST_NAME=?,DOB=?  WHERE USER_ID = ?";

        return DatabaseTemplate.executeQuery(sql, username, email, password, firstName, lastName, DOB, userId);
    }

    @Override
    public boolean removeUser(int userId) {

        String sql = "DELETE FROM users WHERE USER_ID =?";
        return DatabaseTemplate.executeQuery(sql,userId);
    }



    @Override
    public boolean deactivateUser(int userId)
    {
        String sql = "UPDATE users SET ACTIVE = 0 WHERE USER_ID =?";
        return DatabaseTemplate.executeQuery(sql, userId);
    }

    @Override
    public List<User> getAllUsers() {

        String sql = "SELECT * FROM users";

        List<User> users = DatabaseTemplate.queryForObject(sql, new UserRowMapper());

        return users;
    }


    @Override
    public User getUserInfo(int userId) {

        String sql = "SELECT * FROM users WHERE USER_ID =?";

        List<User> users = DatabaseTemplate.queryForObject(sql, new UserRowMapper(),userId);

        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public boolean removeAll() {

        String sql = "DELETE FROM users";
        return DatabaseTemplate.executeQuery(sql);
    }
}
