public class PlayerComp extends Player {

    public PlayerComp(String name){
        super();
        setName(name);
        setOcean(new Ocean());
        placeShips();
    }

    private void placeShips() {
        getOcean().addShip(2, 6, true, 3);
    }

}
