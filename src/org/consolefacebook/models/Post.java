package org.consolefacebook.models;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class Post {

    private int id;
    private int userId;
    private int type;
    private String content;
    private String dateTime;

    public Post() {
    }

    public Post(int id, int userId, int type, String content, String dateTime) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.content = content;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String toString(){

        String postString = "ID :"+id+"\n"+"USER_ID :"+userId+"\n"+"POST_TYPE :"+type+"\n"+
                "CONTENT :"+content+"\n"+"POST_DATETIME :"+dateTime+"\n";

        return postString;
    }
}
