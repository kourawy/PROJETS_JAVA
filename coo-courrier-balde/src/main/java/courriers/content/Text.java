package courriers.content;

public class Text implements Content {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
