package andrusyak.models;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */
public class Gearbox {
    private int id;
    private String name;

    public Gearbox() {
    }

    public Gearbox(int id) {
        this.id = id;
    }

    public Gearbox(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gearbox gearbox = (Gearbox) o;

        return id == gearbox.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
