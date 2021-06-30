package RefactoringTechniques.AdapterPattern.After;

class GalaxianPrime {

    protected String name = "Galaxian Prime";
    private int attackPower = 15;
    protected int spacesMovedPerTurn = 4;

    public void turnOnForceField() {
        System.out.println(name + " turns on.");
    }

    public void warpToSpace() {
        System.out.println(name + " warps " + spacesMovedPerTurn + " spaces.");
    }

    public void chargePhasers() {
        System.out.println(name + " charges phasers.");
    }

    public void firePhasers() {
        System.out.println(name + " fires phasers for " + attackPower + " damage.");
    }
}
