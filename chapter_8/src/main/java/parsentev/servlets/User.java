package parsentev.servlets;

/**
 * TODO: comment.
 * Created by Bogdan on 4/23/2016.
 */
public class User {
    String login;
    String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
