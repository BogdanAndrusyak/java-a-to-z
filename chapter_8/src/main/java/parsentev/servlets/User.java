package parsentev.servlets;

/**
 * TODO: comment.
 * Created by Bogdan on 4/23/2016.
 */
public class User {
    String login;
    String email;
    private String password;

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
