package thebobs.messaging;

/**
 * Created by pablovalero on 12/5/16.
 */

public class Messages {
    private String id;
    private String text;
    private String name;

    public Messages() {
    }

    public Messages(String text, String name, String photoUrl) {
        this.text = text;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
