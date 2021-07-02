package RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories;

// Now that I have Monsters defined, their individual attacks
// & ranges and I have a factory for making them I have to
// create a way to order them.

import RefactoringTechniques.AbstractFactoryPattern.After.Monsters.Monster;

public abstract class AbstractMonsterFactory {

    protected abstract Monster makeMonster(String monsterType);

    public Monster orderMonster(String monsterType) {
        Monster monster = makeMonster(monsterType);

        // Test out the methods for the Monster
        monster.makeMonster();
        monster.checkIfVictimIsInRange();
        monster.attackVictim();
        return monster;
    }
}
