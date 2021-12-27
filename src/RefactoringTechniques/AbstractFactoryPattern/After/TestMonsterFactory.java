package RefactoringTechniques.AbstractFactoryPattern.After;

import RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories.AbstractMonsterFactory;
import RefactoringTechniques.AbstractFactoryPattern.After.MonsterFactories.ConcreteMonsterFactory;
import RefactoringTechniques.AbstractFactoryPattern.After.Monsters.Monster;

class TestMonsterFactory {

    public static void main(String[] args) {
        // Create a way to order new monsters
        AbstractMonsterFactory abstractMonsterFactory = new ConcreteMonsterFactory();

        // Makes a call to the toString method
        Monster zombie = abstractMonsterFactory.orderMonster("Zombie");
        System.out.println(zombie + "\n");
        Monster vampire = abstractMonsterFactory.orderMonster("Vampire");
        System.out.println(vampire + "\n");
    }
}
