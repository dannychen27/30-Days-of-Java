package JavaConcepts.Easy.DeclarationAndInitialization.AccessModifiers.Package3;


class Class8 {

    Class8() {
        System.out.println("I am a default class!");
        Class9 class9 = new Class9();
    }

    private class Class9 {

        private Class9() {
            System.out.println("I am a private class!");
        }
    }
}
