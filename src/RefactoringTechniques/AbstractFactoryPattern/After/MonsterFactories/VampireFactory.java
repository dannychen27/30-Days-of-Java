package RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories;

import RefactoringTechniques.AbstractFactoryPattern.After.AttackPowers.MediumAttack;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackPowers.MonsterAttackPower;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackRanges.MediumRange;
import RefactoringTechniques.AbstractFactoryPattern.After.AttackRanges.MonsterAttackRange;

public class VampireFactory implements MonsterFactory {

    public MonsterAttackPower assignAttackPower() {
        return new MediumAttack();
    }

    public MonsterAttackRange assignAttackRange() {
        return new MediumRange();
    }
}
