package RefactoringTechniques.ComposingMethods.ExtractMethod.Before;

class FootballPlayer {

    private String name = "";
    private double[] fortyYardDashTimes = null;

    String getName() {
        return name;
    }
    double[] get40YardDashTimes() {
        return fortyYardDashTimes;
    }

    FootballPlayer(String name, double[] fortyYardDashTimes) {
        this.name = name;
        this.fortyYardDashTimes = fortyYardDashTimes;
    }
}
