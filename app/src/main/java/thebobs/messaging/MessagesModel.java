package thebobs.messaging;

/**
 * Created by pablovalero on 12/5/16.
 */

public class MessagesModel {
    private String id;
    private String text;
    private String name;

    public MessagesModel() {
    }

    public MessagesModel(String text, String name) {
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
