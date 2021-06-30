package RefactoringTechniques.AdapterPattern.After;

public class Galax implements Enemy {

    private int attackPower = 5;
    private int spacesMovedPerTurn = 2;

    public void moveShip() {
        System.out.println("Galax moves " + spacesMovedPerTurn + " spaces.");
    }

    public void makeShipAttack() {
        System.out.println("Galax does " + attackPower + " damage.");
    }
}
