package RefactoringTechniques.AbstractFactoryPattern.After.Monsters;

import RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories.MonsterFactory;

public class Vampire extends Monster {

    // The type of attack & range to assign are passed into the constructor
    MonsterFactory monsterFactory;

    public Vampire(MonsterFactory monsterFactory) {
        this.monsterFactory = monsterFactory;
    }

    public void makeMonster() {
        System.out.println("Making a vampire.");

        // These are stored in the Monster factory class.
        attackPower = monsterFactory.assignAttackPower();
        attackRange = monsterFactory.assignAttackRange();
    }
}
