package RefactoringTechniques.AbstractFactoryPattern.After.Monsters;

// This class defines attributes and capabilities
// for each monster.

import RefactoringTechniques.AbstractFactoryPattern.After.AttackPowers.MonsterAttackPower;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackRanges.MonsterAttackRange;

public abstract class Monster {

    private String name;

    MonsterAttackPower attackPower;
    MonsterAttackRange attackRange;

    public abstract void makeMonster();

    public void checkIfVictimIsInRange() {
        System.out.println(getName() + " checks if victim is " + attackRange);
    }

    public void attackVictim() {
        System.out.println(getName() + " attacks the victim for " + attackPower);
    }

    public String toString() {
        return getName() + " attacks anything " + attackRange + " for " + attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
