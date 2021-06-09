package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalIntoMethods.After;

class ReplaceConditionalWithMethods {

    public static void main(String[] args) {
        int[] bagWeights = {25, 55, 75};
        int bagFees = 0;

        // These statements will help us figure out how to refactor
        // our conditional statement...
        // bag weight < 50 lbs and there is 1 bag charge $25
        // bag weight < 50 lbs and there is 2 bag charge $35
        // 50 < bag weight < 70 lbs charge $100 if first bag and $150
        // for each additional bag
        // bag weight > 70 lbs charge $200
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
