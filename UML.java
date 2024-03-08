------------------------------------
|            AbstractSceneClass     |
------------------------------------
| - title: String                   |
| - description: String             |
| - choices: String[]               |
------------------------------------
| + AbstractSceneClass(title: String, description: String, choices: String[]) |
| + getTitle(): String              |
| + setTitle(title: String): void   |
| + getDescription(): String       |
| + setDescription(description: String): void |
| + getChoices(): String[]         |
| + setChoices(choices: String[]): void |
| + abstract getNextScene(userChoice: String): AbstractSceneClass |
------------------------------------

--------------------------------
|           Player             |
--------------------------------
| - progress: int              |
| - score: int                 |
--------------------------------
| + Player()                    |
| + getters and setters        |
--------------------------------

----------------------------------------
|         MainStorylineClass           |
----------------------------------------
| - currentScene: AbstractSceneClass   |
| - player: Player                    |
| - gameState: String                 |
| - userChoice: String                |
----------------------------------------
| + MainStorylineClass(initialScene: AbstractSceneClass, player: Player) |
| + getCurrentScene(): AbstractSceneClass |
| + setCurrentScene(currentScene: AbstractSceneClass): void |
| + getPlayer(): Player                |
| + setPlayer(player: Player): void    |
| + getGameState(): String             |
| + setGameState(gameState: String): void |
| + getUserChoice(): String            |
| + setUserChoice(userChoice: String): void |
| + progressStory(): void              |
----------------------------------------

---------------------------------------
|           SceneSubclass             |
---------------------------------------
| - sceneDescription: String          |
| - characters: String[]              |
| - objects: String[]                 |
---------------------------------------
| + SceneSubclass(title: String, description: String, choices: String[], sceneDescription: String, characters: String[], objects: String[]) |
| + getSceneDescription(): String     |
| + setSceneDescription(sceneDescription: String): void |
| + getCharacters(): String[]         |
| + setCharacters(characters: String[]): void |
| + getObjects(): String[]            |
| + setObjects(objects: String[]): void |
| + getNextScene(userChoice: String): AbstractSceneClass |
---------------------------------------

-------------------------------
|         StorytellingApp     |
-------------------------------
| - storyline: MainStorylineClass |
| - titleLabel: Label           |
| - descriptionLabel: Label    |
| - choice1Button: Button      |
| - choice2Button: Button      |
-------------------------------
| + start(primaryStage: Stage): void |
| + createInitialScene(): AbstractSceneClass |
| + handleChoice(choice: String): void |
| + handle(event: ActionEvent): void |
| + updateSceneGUI(): void      |
| + handleKeyPress(keyCode: KeyCode): void |
| + main(args: String[]): void |
-------------------------------
