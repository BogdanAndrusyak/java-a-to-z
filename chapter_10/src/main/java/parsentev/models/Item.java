package parsentev.models;

import java.sql.Timestamp;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 6/7/2016.
 */
public class Item {
    private int id;
    private String desc;
    private Timestamp created;
    private User author;
    private List<Comment> comments;

    public Item() {
    }

    //для удобства
    public Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
