package andrusyak.models;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */
public class Transmission {
    private int id;
    private String name;

    public Transmission() {
    }

    public Transmission(int id) {
        this.id = id;
    }

    public Transmission(String name) {
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

        Transmission that = (Transmission) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
