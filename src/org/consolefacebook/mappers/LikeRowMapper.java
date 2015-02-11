package org.consolefacebook.mappers;



import org.consolefacebook.models.Like;
import org.consolefacebook.models.Post;
import org.consolefacebook.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GALIB on 2/10/2015.
 */
public class LikeRowMapper implements ObjectRowMapper<Like> {

    @Override
    public Like mapRowToObject(ResultSet rs) throws SQLException {

        int id  = rs.getInt("LIKE_ID");
        int postId = rs.getInt("POST_ID");
        int userId  = rs.getInt("USER_ID");
        boolean active = rs.getBoolean("ACTIVE");
        String dateTime = rs.getString("DATETIME");

       return new Like(postId,id,userId,active,dateTime);
    }



}
