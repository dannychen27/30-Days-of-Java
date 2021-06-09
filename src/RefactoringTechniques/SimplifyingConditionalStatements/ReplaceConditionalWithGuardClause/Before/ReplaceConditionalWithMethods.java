package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalWithGuardClause.Before;

class ReplaceConditionalWithMethods {

    public static void main(String[] args) {
        // - With if/else if/else statements, we assume that each conditional is equally likely.
        // - But that's not always true. Some if-statements are more likely to be true than others.
        // so we want to put the if-statements that are more likely first, and less likely statements
        // towards the bottom.
        // - Guard clauses make the normal path of execution more explicit than
        // if-then-else statements
        // - Guard clauses aren't used the way it's shown here: they're most often used to
        // create multiple exit points from a method
        // -- remember: if an input doesn't match precondition, return as soon as possible!
        // - Guard clauses can also eliminate the need for if/else statements.
        int[] bagWeights = {25, 55, 75};
        int bagFees = 0;
        for (int bag = 0; bag < bagWeights.length; bag++) {
            if (bagWeights[bag] < 50) {
                bagFees += bagUnder50lbs(bag);
            } else if (bagWeights[bag] < 70) {
                bagFees += bag50To70lbs(bag);
            } else {
                bagFees += 200;
            }
        }
        System.out.println("Bag Fees: $" + bagFees);
    }

    private static int bagUnder50lbs(int bagNumber) {
        // Notice that bagNumber refers to an index in bagWeights,
        // so we are referring to the 2nd bag in bagWeights.
        return (bagNumber < 1) ? 25 : 35;
    }

    private static int bag50To70lbs(int bagNumber) {
        // Notice that bagNumber refers to an index in bagWeights,
        // so we are referring to the 3rd bag in bagWeights.
        return (bagNumber < 2) ? 100 : 150;
    }
}
