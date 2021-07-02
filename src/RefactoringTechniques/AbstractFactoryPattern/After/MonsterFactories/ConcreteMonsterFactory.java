package RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories;

import RefactoringTechniques.AbstractFactoryPattern.After.Monsters.Monster;
import RefactoringTechniques.AbstractFactoryPattern.After.Monsters.Vampire;
import RefactoringTechniques.AbstractFactoryPattern.After.Monsters.Zombie;

public class ConcreteMonsterFactory extends AbstractMonsterFactory {

    protected Monster makeMonster(String monsterType) {
        Monster monster = null;
        if (monsterType.equals("Zombie")) {
            // Create the factory that assigns the right attributes
            // to each Zombie
            MonsterFactory monsterFactory = new ZombieFactory();

            // Create a Zombie Monster that stores the Objects
            // specific for each zombie so they can be assigned
            // to this monster
            monster = new Zombie(monsterFactory);
            monster.setName("Zombie Bob");
        } else if (monsterType.equals("Vampire")) {
            // Create the factory that assigns the right attributes
            // to each Vampire
            MonsterFactory monsterFactory = new VampireFactory();

            // Create a Vampire Monster that stores the Objects
            // specific for each Vampire so they can be assigned
            // to this monster
            monster = new Vampire(monsterFactory);
            monster.setName("Vampire Paul");
        }
        return monster;
    }
}
