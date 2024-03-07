public class MainStorylineClass {
    private AbstractSceneClass currentScene;
    private Player player;
    private String gameState;
    private String userChoice;

    public MainStorylineClass(AbstractSceneClass initialScene, Player player) {
        this.currentScene = initialScene;
        this.player = player;
        this.gameState = "Running";
    }

    public AbstractSceneClass getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(AbstractSceneClass currentScene) {
        this.currentScene = currentScene;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public void progressStory() {
        // Method to progress the story based on user choices
        if (currentScene != null && userChoice != null) {
            // Get the next scene based on user choice
            AbstractSceneClass nextScene = currentScene.getNextScene(userChoice);
            if (nextScene != null) {
                setCurrentScene(nextScene);
            } else {
                setGameState("Game Over");
            }
        }
    }
}


