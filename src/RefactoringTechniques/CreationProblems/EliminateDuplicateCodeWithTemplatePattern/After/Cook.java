package RefactoringTechniques.CreationProblems.EliminateDuplicateCodeWithTemplatePattern.After;

class Cook {

    public static void main(String[] args) {
        Sandwich customer1 = new Hamburger();
        customer1.makeSandwich();
        Sandwich customer2 = new VeggieSub();
        customer2.makeSandwich();
    }
}
