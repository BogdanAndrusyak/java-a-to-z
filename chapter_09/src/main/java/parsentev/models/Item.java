package parsentev.models;

import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 6/7/2016.
 */
public class Item {
    private User author;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
