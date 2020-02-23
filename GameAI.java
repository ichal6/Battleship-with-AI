import java.util.Random;

public abstract class GameAI extends Game {
    private Random generator;
    protected int difficultyLevel;

    protected int[] randomCoordinates(){
        generator = new Random();
        int x = generator.nextInt(10);
        int y = generator.nextInt(10);

        while(getCurrentPlayer().getOcean().getBoard().get(y).get(x).getIsChosen()){
            generator = new Random();
            x = generator.nextInt(10);
            y = generator.nextInt(10);
            
        }
        int[] coordinatesAsArray = new int[]{x, y};
        return coordinatesAsArray;
    }


    protected int[] getComputerCoordinates(){
        int[] coordinatesAsInt = new int[] {};
        switch(difficultyLevel){
            case 1:
                coordinatesAsInt = randomCoordinates();
                break;
            case 2:
                break;
            case 3:
                break;
        }

        return coordinatesAsInt;
    }

    public void setDifficultyLevel(int level){
        difficultyLevel = level;
    }

    public int getDifficultyLevel(){
        return difficultyLevel;
    }
}