package org.consolefacebook.models;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class Like {

    private int id;
    private int postId;
    private int userId;
    private boolean active;
    private String dateTime;

    public Like() {
    }

    public Like(int postId, int id, int userId, boolean active, String dateTime) {
        this.postId = postId;
        this.id = id;
        this.userId = userId;
        this.active = active;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String toString(){

        String likeString = "LIKE_ID :"+id+"\n"+"USER_ID :"+userId+"\n"+"POST_ID :"+postId+"\n"+
                "DATETIME :"+dateTime+"\n"+"STATUS: "+active+"\n";

        return likeString;
    }
}
