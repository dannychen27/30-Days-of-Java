package RefactoringTechniques.MoveEmbellishmentsUsingDecoratorPattern.Before;

// a bad away to add functionality

// if I add a new haircut style, or change a price,
// I have to modify the code for this class.
// this breaks the single responsibility pattern.

// decorator pattern eliminates adding "special case behaviour" -- embellishments
// put embellishments into own classes

// decorator pattern also satisfies interface segregation principle
// by using many specific interfaces using decorator pattern
// rather than one general purpose interface.

public class CalculateHairCut {

    enum HairCutOptions { BASIC_CUT, PERM, HAIR_FROSTING };

    HairCutOptions optionPicked;

    CalculateHairCut(HairCutOptions options) {
        optionPicked = options;
    }

    public String getDescription() {
        if (optionPicked == HairCutOptions.PERM) {
            return "\nAdd chemicals and put hair in rollers.";
        } else if (optionPicked == HairCutOptions.HAIR_FROSTING) {
            return "\nAdd chemicals and put hair in foil";
        } else {
            return "Trim the hair.";
        }
    }

    public double getCost() {
        if (optionPicked == HairCutOptions.PERM) {
            return 75.00;
        } else if (optionPicked == HairCutOptions.HAIR_FROSTING) {
            return 100.00;
        } else {
            return 10.00;
        }
    }
}
