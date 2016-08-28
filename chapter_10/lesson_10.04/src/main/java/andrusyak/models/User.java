package andrusyak.models;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class User {
    private int id;
    private String name;
    private String login;
    private String password;

    private List<Car> cars;
    private List<QueryCarFilter> queries;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<QueryCarFilter> getQueries() {
        return queries;
    }

    public void setQueries(List<QueryCarFilter> queries) {
        this.queries = queries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
