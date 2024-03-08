import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StorytellingApp extends Application implements EventHandler<ActionEvent> {

    private MainStorylineClass storyline;
    private Label titleLabel;
    private Label descriptionLabel;
    private Button choice1Button;
    private Button choice2Button;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the storyline and initial scene
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

        updateSceneGUI();
        
        // Create and set the scene
        Scene scene = new Scene(root, 400, 300);
        scene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));
        
        choice1Button.setOnAction(this);
        choice2Button.setOnAction(this);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Storytelling App");
        primaryStage.show();
    }

    private AbstractSceneClass createInitialScene() {
        // Create and return the initial scene
        return new SceneSubclass(
            "Welcome to The Door of Destiny",
            "You stand in front of a large door, adorned with intricate carvings.\nAbove it, a sign reads 'The Door of Destiny'. What will you do?",
            new String[]{"Enter", "Turn around and run away"},
            "Image of a door",
            new String[]{"Door"},
            new String[]{"Sign"}
        );
    }

   

    private void handleChoice(String choice) {
        // Set user choice and progress the story
        storyline.setUserChoice(choice);
        storyline.progressStory();

        // Update GUI with the new scene details
        updateSceneGUI();
    }
    
    public void handle(ActionEvent event) {
        if(event.getSource() == choice1Button) {
        	System.out.println("clicked "+choice1Button.getText());
        	handleChoice(choice1Button.getText());
        
        }
        else {
        	System.out.println("clicked "+choice1Button.getText());
        	handleChoice(choice2Button.getText());
        }   
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

    private void handleKeyPress(KeyCode keyCode) {
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

