package org.consolefacebook.mappers;



import org.consolefacebook.models.Post;
import org.consolefacebook.models.User;
import org.consolefacebook.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GALIB on 2/10/2015.
 */
public class PostRowMapper implements ObjectRowMapper<Post> {

    @Override
    public Post mapRowToObject(ResultSet rs) throws SQLException {

        int id  = rs.getInt("POST_ID");
        int userId  = rs.getInt("USER_ID");
        int type = rs.getInt("POST_TYPE");
        String content = rs.getString("CONTENT");
        String dateTime = rs.getString("DATETIME");

       return new Post(id,userId, type, content, dateTime);
    }



}
