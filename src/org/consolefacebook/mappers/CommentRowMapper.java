package org.consolefacebook.mappers;



import org.consolefacebook.models.Comment;
import org.consolefacebook.models.User;
import org.consolefacebook.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GALIB on 2/10/2015.
 */
public class CommentRowMapper implements ObjectRowMapper<Comment> {

    @Override
    public Comment mapRowToObject(ResultSet rs) throws SQLException {

        int commentId  = rs.getInt("COMMENT_ID");
        int userId  = rs.getInt("USER_ID");
        int postId = rs.getInt("POST_ID");
        String content = rs.getString("CONTENT");
        String dateTime = rs.getString("DATETIME");

        return new Comment(commentId,postId, userId, content, dateTime);
    }



}
