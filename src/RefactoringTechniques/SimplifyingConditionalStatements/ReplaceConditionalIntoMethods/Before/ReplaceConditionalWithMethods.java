package RefactoringTechniques.SimplifyingConditionalStatements.ReplaceConditionalIntoMethods.Before;

class ReplaceConditionalWithMethods {

    public static void main(String[] args) {
        // To remove this nested conditional statement, we can extract them
        // into methods to improve readability.

        int[] bagWeight = new int[] {25, 55, 75};
        int numberOfBags = bagWeight.length;
        int bagFees = 0;
        for (int i = 0; i < numberOfBags; i++) {
            if (i <= 1) {
                if (bagWeight[i] < 50) {
                    if (i == 0) {
                        bagFees += 25;
                    } else {
                        bagFees += 35;
                    }
                } else if (bagWeight[i] < 70) {
                    bagFees += 100;
                }
            } else if (i > 1 && bagWeight[i] < 70) {
                bagFees += 150;
            } else {
                bagFees += 200;
            }
        }
        System.out.println("Bag Fees: $" + bagFees);
    }
}
