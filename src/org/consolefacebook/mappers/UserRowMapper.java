package org.consolefacebook.mappers;



import org.consolefacebook.models.User;
import org.consolefacebook.util.ObjectRowMapper;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GALIB on 2/10/2015.
 */
public class UserRowMapper implements ObjectRowMapper<User> {

    @Override
    public User mapRowToObject(ResultSet rs) throws SQLException {

        int id  = rs.getInt("USER_ID");
        String username = rs.getString("USER_NAME");
        String email = rs.getString("EMAIL");
        String password = rs.getString("PASSWORD");
        boolean active = rs.getBoolean("ACTIVE");

        String firstName = rs.getString("FIRST_NAME");
        String lastName = rs.getString("LAST_NAME");
        String DOB = rs.getString("DOB");

        return new User(id,username,email,password,active,firstName,lastName,DOB);
    }



}
