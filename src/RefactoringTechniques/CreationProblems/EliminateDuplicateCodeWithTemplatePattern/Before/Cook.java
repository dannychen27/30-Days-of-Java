package RefactoringTechniques.CreationProblems.EliminateDuplicateCodeWithTemplatePattern.Before;

class Cook {

    public static void main(String[] args) {
        Hamburger customer1 = new Hamburger();
        customer1.makeSandwich();
        VeggieSub customer2 = new VeggieSub();
        customer2.makeSandwich();
    }
}
