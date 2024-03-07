-------------------------------------
|          MainStorylineClass       |
-------------------------------------
| - currentScene: AbstractScene     |
| - player: Player                  |
| - gameState: GameState            |
| - userChoice: String              |
-------------------------------------
| + startGame(): void               |
| + loadScene(scene: AbstractScene): void |
| + getUserChoice(): String         |
| + updateGameState(): void         |
-------------------------------------

-------------------------------------
|        AbstractSceneClass         |
-------------------------------------
| - title: String                   |
| - description: String             |
| - choices: String[]               |
-------------------------------------
| + displayScene(): void            |
| + getUserInput(): void            |
| + getTitle(): String              |
| + setTitle(title: String): void   |
| + getDescription(): String        |
| + setDescription(description: String): void |
| + getChoices(): String[]          |
| + setChoices(choices: String[]): void |
-------------------------------------

-------------------------------------
|         SceneSubclass             |
-------------------------------------
| - sceneDescription: String        |
| - characters: String[]            |
| - objects: String[]               |
-------------------------------------
| + customMethod1(): void           |
| + customMethod2(): void           |
| + getSceneDescription(): String   |
| + setSceneDescription(sceneDescription: String): void |
| + getCharacters(): String[]       |
| + setCharacters(characters: String[]): void |
| + getObjects(): String[]          |
| + setObjects(objects: String[]): void |
-------------------------------------

-------------------------------------
|               Player              |
-------------------------------------
| - name: String                    |
| - progress: int                   |
| - score: int                      |
-------------------------------------
| + getName(): String               |
| + setName(name: String): void     |
| + getProgress(): int              |
| + setProgress(progress: int): void |
| + getScore(): int                 |
| + setScore(score: int): void      |
-------------------------------------

-------------------------------------
|             GameState             |
-------------------------------------
| - state: String                   |
-------------------------------------
| + getState(): String              |
| + setState(state: String): void  |
-------------------------------------
