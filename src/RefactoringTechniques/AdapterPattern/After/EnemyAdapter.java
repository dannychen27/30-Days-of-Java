package RefactoringTechniques.AdapterPattern.After;

public class EnemyAdapter implements Enemy {

    GalaxianPrime galaxianPrime;

    public EnemyAdapter(GalaxianPrime galaxianPrime) {
        this.galaxianPrime = galaxianPrime;
    }

    public void moveShip() {
        galaxianPrime.turnOnForceField();
        galaxianPrime.warpToSpace();
    }

    public void makeShipAttack() {
        galaxianPrime.chargePhasers();
        galaxianPrime.firePhasers();
    }
}
