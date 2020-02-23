public abstract class Player {
    private String name;
    private Ocean ocean;
    

    public boolean hasLost(){
        return ocean.hasLost();
    }

    public boolean shoot(int[] coordinates){
        return ocean.isShot(coordinates[0],coordinates[1]);
    }

    public boolean isSunk(int[] coordinates){
        return ocean.isSunk(coordinates[0], coordinates[1]);
    }

    public Ocean getOcean() {
        return ocean;
    }

    public String getName() {
        return name;
    }

    public void setOcean(Ocean ocean){
        this.ocean = ocean;
    }

    public void setName(String name){
        this.name = name;
    }
}