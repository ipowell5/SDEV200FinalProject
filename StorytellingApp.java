import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StorytellingApp extends Application {

    private MainStorylineClass storyline;
    private Label titleLabel;
    private Label descriptionLabel;
    private Button choice1Button;
    private Button choice2Button;

    @Override
    public void start(Stage primaryStage) {
        // Initialize your storyline and initial scene
        AbstractSceneClass initialScene = createInitialScene();
        Player player = new Player();
        storyline = new MainStorylineClass(initialScene, player);

        // Create GUI components
        titleLabel = new Label();
        descriptionLabel = new Label();
        choice1Button = new Button();
        choice2Button = new Button();
        

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(titleLabel, descriptionLabel, choice1Button, choice2Button);

        // moved this here
        updateSceneGUI();
        
        // Create and set the scene
        Scene scene = new Scene(root, 400, 300);
        scene.setOnMouseMoved(e -> handleMouseHover(e.getX(), e.getY()));
        scene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Storytelling App");
        primaryStage.show();
    }

    private AbstractSceneClass createInitialScene() {
        // Create and return the initial scene
        return new SceneSubclass(
            "Welcome to The Door of Destiny",
            "You stand in front of a large door, adorned with intricate carvings. Above it, a sign reads 'The Door of Destiny'. What will you do?",
            new String[]{"Enter", "Turn around and run away"},
            "Image of a door",
            new String[]{"Door"},
            new String[]{"Sign"}
        );
    }

    private AbstractSceneClass createScene2() {
        // Create and return scene 2
        return new SceneSubclass(
            "Dark Forest Encounter",
            "You open the door and find yourself in a dark forest. As you walk, a comically large owl perches on a branch. It asks for a token of gratitude. What will you give?",
            new String[]{"Give the large owl your quarter", "Give the large owl your gum"},
            "Image of a large owl",
            new String[]{"Owl"},
            new String[]{"Path"}
        );
    }

    private AbstractSceneClass createScene3Quarter() {
        // Create and return scene 3 if quarter is given
        return new SceneSubclass(
            "Owl Attack",
            "You give the large owl your quarter. In a flash, it transforms into a ferocious creature and attacks you. Your adventure ends here.",
            new String[]{},
            "Image of a terrifying owl",
            new String[]{"Creature"},
            new String[]{"Path"}
        );
    }

    private AbstractSceneClass createScene3Gum() {
        // Create and return scene 3 if gum is given
        return new SceneSubclass(
            "Forest Path",
            "The owl happily accepts your gum and lets you pass. You continue down the forest path.",
            new String[]{},
            "Image of a forest path",
            new String[]{"Trees"},
            new String[]{"Path"}
        );
    }

    private AbstractSceneClass createScene4Apple() {
        // Create and return scene 4 if apple is eaten
        return new SceneSubclass(
            "The Forbidden Apple",
            "You take a bite from the golden apple. Immediately, you feel a strange sensation in your body. You collapse to the ground, paralyzed. Your journey ends here.",
            new String[]{},
            "Image of a golden apple",
            new String[]{"Apple"},
            new String[]{"Path"}
        );
    }

    private AbstractSceneClass createScene4Pocket() {
        // Create and return scene 4 if apple is put in pocket
        return new SceneSubclass(
            "Castle Encounter",
            "As you approach the castle, you find a golden gate. You show the golden apple to the guards, and they allow you to enter. Inside, you encounter a beautiful elven princess.",
            new String[]{"Tell her you are here to rescue her", "Give her the golden apple from your pocket"},
            "Image of a castle",
            new String[]{"Castle"},
            new String[]{"Gate"}
        );
    }

    private void handleChoice(String choice) {
        // Set user choice and progress the story
        storyline.setUserChoice(choice);
        storyline.progressStory();

        // Update GUI with the new scene details
        updateSceneGUI();
    }

    private void updateSceneGUI() {
        // Update GUI with the details of the current scene
        AbstractSceneClass currentScene = storyline.getCurrentScene();
        titleLabel.setText(currentScene.getTitle());
        descriptionLabel.setText(currentScene.getDescription());

        // Clear previous choices and add new choice buttons
        VBox root = (VBox) titleLabel.getParent();
        root.getChildren().removeAll(choice1Button, choice2Button);
        if (currentScene.getChoices().length > 0) {
            choice1Button.setText(currentScene.getChoices()[0]);
            choice1Button.setOnAction(e -> handleChoice(currentScene.getChoices()[0]));
            root.getChildren().add(choice1Button);
        }
        if (currentScene.getChoices().length > 1) {
            choice2Button.setText(currentScene.getChoices()[1]);
            choice2Button.setOnAction(e -> handleChoice(currentScene.getChoices()[1]));
            root.getChildren().add(choice2Button);
        }
    }

    private void handleMouseHover(double x, double y) {
        // Implement mouse hover event
        // Provide additional information or context based on the hovered element
        System.out.println("Mouse Hover: (" + x + ", " + y + ")");
    }

    private void handleKeyPress(KeyCode keyCode) {
        // Implement keyboard input event
        System.out.println("Key Pressed: " + keyCode);
        if (keyCode == KeyCode.ENTER) {
            // click the first choice button when Enter key is pressed
            choice1Button.fire();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

