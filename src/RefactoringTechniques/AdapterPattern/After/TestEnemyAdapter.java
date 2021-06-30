package RefactoringTechniques.AdapterPattern.After;

public class TestEnemyAdapter {

    public static void main(String[] args) {
        Enemy galax = new Galax();
        galax.moveShip();
        galax.makeShipAttack();
        System.out.println();

        // use GalaxianPrime like an enemy
        GalaxianPrime galaxianPrimeAdaptee = new GalaxianPrime();
        Enemy galaxPrime = new EnemyAdapter(galaxianPrimeAdaptee);
        galaxPrime.moveShip();
        galaxPrime.makeShipAttack();
    }
}
