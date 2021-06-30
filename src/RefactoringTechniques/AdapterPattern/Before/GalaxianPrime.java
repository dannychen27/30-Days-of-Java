package RefactoringTechniques.AdapterPattern.Before;

class GalaxianPrime extends EnemyShip {

    public GalaxianPrime(int currentLevel) {
        super(currentLevel);
    }

    public void moveShip() {
        System.out.println(name + " turns on forcefield and moves " + spacesMovedPerTurn + " spaces.");
    }
}
