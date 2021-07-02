package RefactoringTechniques.AbstractFactoryPattern.After.Monsters;

import RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories.MonsterFactory;

public class Zombie extends Monster {

    // A factory is sent into this class that will assign
    // the right objects for attack and range to the Zombie
    // The type of attack & range to assign are passed into the constructor
    MonsterFactory monsterFactory;

    public Zombie(MonsterFactory monsterFactory) {
        this.monsterFactory = monsterFactory;
    }

    public void makeMonster() {
        System.out.println("Making a zombie.");

        // These are stored in the Monster factory class.
        attackPower = monsterFactory.assignAttackPower();
        attackRange = monsterFactory.assignAttackRange();
    }
}
