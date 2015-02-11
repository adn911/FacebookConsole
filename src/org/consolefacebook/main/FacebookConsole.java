package org.consolefacebook.main;

import org.consolefacebook.models.Comment;
import org.consolefacebook.models.Post;
import org.consolefacebook.models.User;
import org.consolefacebook.services.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bakhtiar.galib on 2/9/15.
 */
public class FacebookConsole {

    Scanner scanner;
    UserService userService;
    PostService postService;
    CommentService commentService;
    LikeService likeService;
    FriendService friendService;
    User currentUser;

    public FacebookConsole() {

        this.scanner = new Scanner(System.in);
        this.userService = new UserServiceImpl();
        this.postService = new PostServiceImpl();
        this.commentService = new CommentServiceImpl();
        this.likeService = new LikeServiceImpl();
        this.friendService = new FriendServiceImpl();
    }

    public void run() {

        int choice = 0;

        do {

            System.out.println("WELCOME TO FACEBOOK CONSOLE..");
            System.out.println("1. LOGIN");
            System.out.println("2. REGISTER ");
            System.out.println("3. EXIT ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1: {
                    login();
                    break;
                }

                case 2: {
                    register();
                    break;
                }

                case 3: {

                    break;
                }
            }

        } while (choice != 3);

    }

    private void runMain() {

        System.out.println("WELCOME " + currentUser.getUsername());

        int choice = 0;


        do {

            try {
                // System.out.println("WELCOME TO FACEBOOK CONSOLE..");
                System.out.println("1. SHOW NEWSFEED");
                System.out.println("2. POST STATUS");
                System.out.println("3. REMOVE STATUS");
                System.out.println("5. ADD COMMENT");
                System.out.println("6. REMOVE COMMENT");
                System.out.println("7. ADD FRIEND");
                System.out.println("8. REMOVE FRIEND");
                System.out.println("9. SHOW FRIENDS LIST");
                System.out.println("10. UPDATE INFO");
                System.out.println("11. SHOW INFO");
                System.out.println("12. LOGOUT");

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1: {
                        showNewsFeed();
                        break;
                    }

                    case 2: {
                        postStatus();
                        break;
                    }

                    case 3: {
                        removeStatus();
                        break;
                    }

                    case 4: {
                        addLike();
                        break;
                    }

                    case 5: {
                        addComment();
                        break;
                    }

                    case 6: {
                        removeComment();
                        break;
                    }

                    case 7: {
                        addFriend();
                        break;
                    }

                    case 8: {
                        removeFriend();
                        break;
                    }

                    case 9: {
                        showFriendsList();
                        break;
                    }

                    case 10: {
                        editInfo();
                        break;
                    }

                    case 11: {
                        showUserInfo();
                        break;
                    }

                    case 12: {

                        break;
                    }
                }

            } catch (NumberFormatException ex) {
                System.out.println("ERROR: ENTER A VALID NUMBER");

            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }

        } while (choice != 12);

    }


    private void showFriendsList() {

        List<User> friends = friendService.getFriends(currentUser.getUserId());

        if (friends.size() > 0) {

            System.out.println("FRIENDS LIST ");
            System.out.println("******************************");

            for (User user : friends) {
                System.out.println(user.getUserId() + "=>" + user.getUsername());
            }

            System.out.println();

        } else {

            System.out.println("YOU DON't HAVE ANY FRIENDS YET..");
        }


    }

    private void showUserInfo() {

        System.out.println("USER INFORMATION \n");
        System.out.println(currentUser);
    }

    public void login() {

        String email, password;

        System.out.println("ENTER EMAIL: ");
        email = scanner.nextLine();

        System.out.println("ENTER PASSWORD: ");
        password = scanner.nextLine();

        currentUser = userService.loginUser(email, password);

        if (currentUser != null) {
            runMain();

        } else {
            System.out.println("LOGIN FAILED.. ");
        }

    }

    public void register() {

        String username, firstName, lastName, email, password, DOB, formattedDOB;

        System.out.println("#####################################");
        System.out.println("USER REGISTRATION ..");
        System.out.println("#####################################");

        System.out.println("ENTER USERNAME: ");
        username = scanner.nextLine();

        System.out.println("ENTER EMAIL: ");
        email = scanner.nextLine();

        System.out.println("ENTER PASSWORD: ");
        password = scanner.nextLine();

        System.out.println("ENTER FIRSTNAME: ");
        firstName = scanner.nextLine();

        System.out.println("ENTER LASTNAME: ");
        lastName = scanner.nextLine();

        System.out.println("ENTER DOB (yyyy-mm-dd): ");
        DOB = scanner.nextLine();

        /*formattedDOB = new SimpleDateFormat("YYYY-mm-dd").format(new Date(DOB)) ;

        System.out.println(formattedDOB);*/

       if (userService.createNewUser(username, email, password, firstName, lastName, DOB)) {

            System.out.println("REGISTRATION SUCCESSFUL ..");

        } else {

            System.out.println("REGISTRATION FAILED.. ");
        }
    }


    private void showNewsFeed() {

        List<Post> posts = postService.getNewsFeedPosts(currentUser.getUserId());

        System.out.println("*****************************************");
        System.out.println("FACEBOOK ");
        System.out.println("*****************************************");


        for (Post post : posts) {


            User postUser = userService.getUserInfo(post.getUserId());

            System.out.println(postUser.getUsername() + " POSTED AT " + post.getDateTime() + " => " + post.getContent() + "\n");

            List<Comment> postComments = commentService.getPostComments(post.getId());

            for (Comment comment : postComments) {

                User commentMaker = userService.getUserInfo(comment.getUserId());
                System.out.println("\t " + commentMaker.getUsername() + " COMMENTED AT" + comment.getDateTime() + " => " + comment.getContent());
            }

            System.out.println();
        }


    }


    private void postStatus() {

        System.out.println("ENTER STATUS: ");
        String status = scanner.nextLine();
        String datetime = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date());
        System.out.println(datetime);

        postService.createNewPost(currentUser.getUserId(), 1, status, datetime);


    }

    private void removeStatus() {

        List<Post> posts = postService.getUserPosts(currentUser.getUserId());

        for (Post post : posts) {

            User postUser = userService.getUserInfo(post.getUserId());

            System.out.println(post.getId() + "# " + postUser.getUsername() + " AT " + post.getDateTime() + " => " + post.getContent() + "\n");
        }

        System.out.println("SELECT STATUS ID TO REMOVE ..");

        int statusId = Integer.parseInt(scanner.nextLine());

        postService.removePost(statusId);

    }

    private void addComment() {

        List<Post> posts = postService.getNewsFeedPosts(currentUser.getUserId());

        for (Post post : posts) {

            User postUser = userService.getUserInfo(post.getUserId());

            System.out.println(post.getId() + "# " + postUser.getUsername() + " AT " + post.getDateTime() + " => " + post.getContent() + "\n");
        }

        System.out.println("SELECT STATUS ID TO COMMENT ON ..");

        int statusId = Integer.parseInt(scanner.nextLine());

        System.out.println("ENTER YOUR COMMENT: ");

        String comment = scanner.nextLine();

        String datetime = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date());

        commentService.createNewComment(statusId, currentUser.getUserId(), comment, datetime);
    }


    private void removeComment() {

        List<Comment> userComments = commentService.getUserComments(currentUser.getUserId());

        if (userComments.size() > 0) {

            for (Comment comment : userComments) {

                System.out.println(comment.getId() + "# " + comment.getContent() + "\n");
            }

            System.out.println("SELECT YOUR COMMENT ID TO REMOVE ..");

            int commentId = Integer.parseInt(scanner.nextLine());

            commentService.removeComment(commentId);

        } else {

            System.out.println("YOU DON't HAVE ANY COMMENTS ");
        }

    }

    private void addLike() {

    }

    private void editInfo() {

        String username, firstName, lastName, email, password, DOB, formattedDOB;

        System.out.println(currentUser);

        System.out.println("EDIT/UPDATE USER INFO\n");

        System.out.println("ENTER USERNAME: ");
        username = scanner.nextLine();

        System.out.println("ENTER EMAIL: ");
        email = scanner.nextLine();

        System.out.println("ENTER PASSWORD: ");
        password = scanner.nextLine();

        System.out.println("ENTER FIRSTNAME: ");
        firstName = scanner.nextLine();

        System.out.println("ENTER LASTNAME: ");
        lastName = scanner.nextLine();

        System.out.println("ENTER DOB (yyyy-mm-dd): ");
        DOB = scanner.nextLine();

        if (userService.updateUser(currentUser.getUserId(), username, email, password, firstName, lastName, DOB)) {

            System.out.println("INFO UPDATED SUCCESSFULLY");

            currentUser = userService.getUserInfo(currentUser.getUserId());

            System.out.println("UPDATED USER INFO ");

            System.out.println(currentUser);

        } else {

            System.out.println("INFO UPDATE FAILED..");

        }


    }


    private void addFriend() {

        List<User> notFriendUsers = friendService.getUsersNotFriend(currentUser.getUserId());

        if (notFriendUsers.size() > 0) {

            for (User user : notFriendUsers) {

                System.out.println(user.getUserId() + "=>" + user.getUsername());
            }

            System.out.println("ENTER USER_ID TO FRIEND..");

            int friendId = Integer.parseInt(scanner.nextLine());

            friendService.addFriend(currentUser.getUserId(), friendId);

            System.out.println(currentUser.getUsername() + " AND " +
                    userService.getUserInfo(friendId).getUsername() + " ARE NOW FRIENDS");
        } else {

            System.out.println("NO USERS TO BE FRIENDS WITH!!");
        }

    }


    private void removeFriend() {

        List<User> friends = friendService.getFriends(currentUser.getUserId());

        if (friends.size() > 0) {

            for (User user : friends) {
                System.out.println(user.getUserId() + "=>" + user.getUsername());
            }

            System.out.println("ENTER FRIEND ID YOU WANT TO REMOVE: ");

            int friendId = Integer.parseInt(scanner.nextLine());
            friendService.removeFriend(currentUser.getUserId(), friendId);

            System.out.println(currentUser.getUsername() + " AND " +
                    userService.getUserInfo(friendId).getUsername() + " ARE NO LONGER FRIENDS");
        } else {

            System.out.println("YOU DON't HAVE ANY FRIENDS!");
        }
    }


}
