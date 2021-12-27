package RefactoringTechniques.CreationProblems.ReplacingConstructorsWithCreationMethods.After;

class FootballPlayer {

    private double passerRating; // specific to QBs
    private int rushingYards; // specific to RBs and QBs
    private int receivingYards; // specific to RBs and WRs
    private int totalTackles; // specific to DEF
    private int interceptions; // specific to DEF
    private int fieldGoals; // specific to Kickers
    private double avgPunt; // specific to Punters
    private double avgKickoffReturn; // specific to Special Teams
    private double avgPuntReturn; // specific to Special Teams

    private FootballPlayer(double passerRating, int rushingYards, int receivingYards,
                           int totalTackles, int interceptions, int fieldGoals,
                           double avgPunt, double avgKickoffReturn, double avgPuntReturn) {
        this.passerRating = passerRating;
        this.rushingYards = rushingYards;
        this.receivingYards = receivingYards;
        this.totalTackles = totalTackles;
        this.interceptions = interceptions;
        this.fieldGoals = fieldGoals;
        this.avgPunt = avgPunt;
        this.avgKickoffReturn = avgKickoffReturn;
        this.avgPuntReturn = avgPuntReturn;
    }

    private double getPasserRating() {
        return passerRating;
    }

    // Creation Methods (which are static)
    // - Most of the parameters are uninitialized, which is fine for this refactoring technique.
    // - although using the Builder design pattern would be better, to only initialize the attributes we want.

    private static FootballPlayer createQB(double passerRating, int rushingYards) {
        return new FootballPlayer(passerRating, rushingYards, 0,
                0, 0, 0,
                0.0, 0.0,0.0);
    }

    public static FootballPlayer createRB(int rushingYards) {
        return new FootballPlayer(0, rushingYards, 0,
                0, 0, 0,
                0.0, 0.0, 0.0);
    }

    public static FootballPlayer createWR(int receivingYards) {
        return new FootballPlayer(0, 0, receivingYards,
                0, 0, 0,
                0.0, 0.0, 0.0);
    }

    public static FootballPlayer createDEF(int totalTackles, int interceptions) {
        return new FootballPlayer(0, 0, 0,
                totalTackles, interceptions, 0,
                0.0, 0.0, 0.0);
    }

    public static FootballPlayer createKicker(int fieldGoals) {
        return new FootballPlayer(0, 0, 0,
                0, 0, fieldGoals,
                0.0, 0.0, 0.0);
    }

    public static FootballPlayer createPunter(double avgPunt) {
        return new FootballPlayer(0, 0, 0,
                0, 0, 0,
                avgPunt, 0.0, 0.0);
    }

    public static FootballPlayer createSpecialTeam(double avgKickoffReturn,
                                                   double avgPuntReturn) {
        return new FootballPlayer(0, 0, 0,
                0, 0, 0,
                0.0, avgKickoffReturn, avgPuntReturn);
    }

    public static void main(String[] args) {
        FootballPlayer sterlingKnight = FootballPlayer.createQB(108.0, 259);
        System.out.println("Sterling Knight Passer Rating: " + sterlingKnight.getPasserRating());
    }
}
