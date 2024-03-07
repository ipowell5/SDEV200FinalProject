// AbstractSceneClass.java
public abstract class AbstractSceneClass {
    protected String title;
    protected String description;
    protected String[] choices;

    public AbstractSceneClass(String title, String description, String[] choices) {
        this.title = title;
        this.description = description;
        this.choices = choices;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    // Abstract method to be implemented by subclasses to get the next scene based on user choice
    public abstract AbstractSceneClass getNextScene(String userChoice);
}

