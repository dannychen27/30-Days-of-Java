package RefactoringTechniques.AdapterPattern.Before;

class EnemyShip {

    // use multiple types of enemy ships.

    protected String name;
    private int attackPower;
    protected int spacesMovedPerTurn;

    public EnemyShip(int currentLevel) {
        if (currentLevel <= 5) {
            name = "Galax";
            attackPower = 5;
            spacesMovedPerTurn = 2;
        } else if (currentLevel < 10) {
            name = "Galaxian";
            attackPower = 10;
            spacesMovedPerTurn = 3;
        } else {
            name = "Galaxian Prime";
            attackPower = 15;
            spacesMovedPerTurn = 4;
        }
    }

    public void moveShip() {
        System.out.println(name + " moves " + spacesMovedPerTurn + " spaces.");
    }

    public void makeShipAttack() {
        System.out.println(name + " does " + attackPower + " damage.");
    }

    public static void main(String[] args) {
        EnemyShip level1Ship = new EnemyShip(1);
        level1Ship.moveShip();
        level1Ship.makeShipAttack();
        System.out.println();

        GalaxianPrime primeTime = new GalaxianPrime(15);
        primeTime.moveShip();
        primeTime.makeShipAttack();
        // how does a GalaxianPrime turn on, activate their forcefield,
        // charge and fire their phaser?
    }
}
