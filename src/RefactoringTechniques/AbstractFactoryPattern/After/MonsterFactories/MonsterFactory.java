package RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories;

// Here I define the attributes for each monster
// and the methods that will define them

import RefactoringTechniques.AbstractFactoryPattern.After.AttackPowers.MonsterAttackPower;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackRanges.MonsterAttackRange;

public interface MonsterFactory {

    MonsterAttackPower assignAttackPower();
    MonsterAttackRange assignAttackRange();
}
