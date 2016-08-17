package andrusyak.models;

import java.sql.Timestamp;

/**
 * TODO: comment.
 * Created by Bogdan on 8/16/2016.
 */
public class Item {
    private int id;
    private String desc;
    private Timestamp created = new Timestamp(System.currentTimeMillis()); // by default
    private boolean done = false;

    public Item() {
    }

    // for delete
    public Item(int id) {
        this.id = id;
    }

    // for create from view
    public Item(String desc) {
        this.desc = desc;
    }

    // for update from view | actually only update field done
    public Item(int id, boolean done) {
        this.id = id;
        this.done = done;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
