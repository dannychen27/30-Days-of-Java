package RefactoringTechniques.AbstractFactoryPattern;

public class AbstractFactoryPattern {
    // source: https://www.youtube.com/watch?v=riuRTxV01Vo&list=PLGLfVvz_LVvSuz6NuHAzpM52qKM6bPlCV&index=18

    // abstract factory pattern

    // The Basics of the Abstract Design Pattern:
    // 1. There is a Monster abstract class
    // 2. The difference between the Monsters is the Objects stored in Attack and Range
    // 3. An interface is used to represent both options available for Attack and Range
    // 4. 2 classes implement that Attack & Range interfaces
    // 5. There is a MonsterFactories interface. It represents monsters with different Attack & Range types
    // 6. If I want a Vampire with a MediumAttack & MediumRange a Vampire Factory is made that assigns those classes to the Vampire objects Attack & Range attributes
    // 7. The only thing left is the builder that receives a string.
    // If the String is a Vampire we pass the Vampire Factory into the Vampire class Object.
    // 8. The Vampire class object assigns the Attack & Range Objects as the attributes for Attack & Range for every Vampire Object that is created.
}
