package andrusyak.models;

/**
 * TODO: comment.
 * Created by Bogdan on 8/22/2016.
 */
public class File {
    private String name;
    private byte[] content;

    public File(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
