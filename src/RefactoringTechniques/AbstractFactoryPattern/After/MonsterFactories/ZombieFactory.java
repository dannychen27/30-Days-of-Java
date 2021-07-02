package RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories;

// This defines the attack and range to assign to each Zombie created

import RefactoringTechniques.AbstractFactoryPattern.After.AttackPowers.BasicAttack;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackPowers.MonsterAttackPower;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackRanges.BasicRange;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackRanges.MonsterAttackRange;

public class ZombieFactory implements MonsterFactory {

    public MonsterAttackPower assignAttackPower() {
        return new BasicAttack();
    }

    public MonsterAttackRange assignAttackRange() {
        return new BasicRange();
    }
}
