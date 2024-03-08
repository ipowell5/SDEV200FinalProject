// SceneSubclass.java (an example subclass)
public class SceneSubclass extends AbstractSceneClass {
    private String sceneDescription;
    private String[] characters;
    private String[] objects;

    public SceneSubclass(String title, String description, String[] choices, String sceneDescription, String[] characters, String[] objects) {
        super(title, description, choices);
        this.sceneDescription = sceneDescription;
        this.characters = characters;
        this.objects = objects;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }

    public void setSceneDescription(String sceneDescription) {
        this.sceneDescription = sceneDescription;
    }

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }

    public String[] getObjects() {
        return objects;
    }

    public void setObjects(String[] objects) {
        this.objects = objects;
    }

    @Override
    public AbstractSceneClass getNextScene(String userChoice) {
    	System.out.println("getting next scene ..."+userChoice);
    	switch (userChoice) {

        case "Enter":
        	return new SceneSubclass(
    	            "Dark Forest Encounter",
    	            "You open the door and find yourself in a dark forest.\nAs you walk, a comically large owl perches on a branch.\nIt asks for a token of gratitude. What will you give?",
    	            new String[]{"Give the large owl your quarter", "Give the large owl your gum"},
    	            "Image of a large owl",
    	            new String[]{"Owl"},
    	            new String[]{"Path"}
    	        );

        case "Turn around and run away":
        	return new SceneSubclass(
    	            "Run Away",
    	            "You run away. Your adventure ends here.",
    	            new String[]{},
    	            "Image of the end",
    	            new String[]{"Creature"},
    	            new String[]{"Path"}
    	        );
        case "Give the large owl your quarter":
        	return new SceneSubclass(
    	            "Owl Attack",
    	            "You give the large owl your quarter.\nIn a flash, it transforms into a ferocious creature and attacks you.\nYour adventure ends here.",
    	            new String[]{},
    	            "Image of a terrifying owl",
    	            new String[]{"Creature"},
    	            new String[]{"Path"}
    	        );
        case "Give the large owl your gum":
        	 return new SceneSubclass(
     	            "Forest Path",
     	            "The owl happily accepts your gum and lets you pass.\nYou continue down the forest path and find an Apple",
     	            new String[]{"Eat the apple","Keep walking to the castle"},
     	            "Image of a forest path",
     	            new String[]{"Trees"},
     	            new String[]{"Path"}
     	        );
        case "Eat the apple":
        	 return new SceneSubclass(
     	            "The Forbidden Apple",
     	            "You take a bite from the golden apple.\nImmediately, you feel a strange sensation in your body.\nYou collapse to the ground, paralyzed\nYour journey ends here.",
     	            new String[]{},
     	            "Image of a golden apple",
     	            new String[]{"Apple"},
     	            new String[]{"Path"}
     	        );
            
        case "Keep walking to the castle":
        	return new SceneSubclass(
    	            "Castle Encounter",
    	            "As you approach the castle, you find a golden gate.\nYou show the golden apple to the guards, and they allow you to enter.\nInside, you encounter a beautiful elven princess.",
    	            new String[]{"Tell her you are here to rescue her", "Give her the golden apple from your pocket"},
    	            "Image of a castle",
    	            new String[]{"Castle"},
    	            new String[]{"Gate"}
    	        );

    	case "Tell her you are here to rescue her":
    		return new SceneSubclass(
    				"Resue",
    				"You rescue the princess and live happily ever after.",
    				new String[]{},
    	            "Image of a wedding",
    	            new String[]{"Creature"},
    	            new String[]{"Path"}
    				);
		case "Give her the golden apple from your pocket":
			return new SceneSubclass(
					"Eating the apple",
					"The princess says thank you and eats the apple. Your adventure ends here.",
					new String[]{},
					"Image of a castle",
					new String[]{"Castle"},
					new String[]{"Gate"}
        );
    	}
    	
    	
        return null;
    }
}
