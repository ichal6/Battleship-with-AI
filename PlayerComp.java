public class PlayerComp extends Player {

    public PlayerComp(String name){
        super();
        setName(name);
        setOcean(new Ocean());
        placeShips();
    }

    private void placeShips() {
        getOcean().addShip(0, 0, true, 3);
    }

}
