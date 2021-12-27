package RefactoringTechniques.CreationProblems.ReplacingConstructorsWithCreationMethods.Before;

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

    // - Process: I create one constructor for each kind of FootballPlayer.
    // - Problem: Some of my FootballPlayer constructors have the same constructor signature,
    // despite having different parameter names.

    // for the QBs (quarterbacks)
    private FootballPlayer(double passerRating, int rushingYards) {
        this.passerRating = passerRating;
        this.rushingYards = rushingYards;
    }

    private double getPasserRating() {
        return passerRating;
    }

    // for the RBs (runningbacks)
    private FootballPlayer(int rushingYards) {
        this.rushingYards = rushingYards;
    }

    // for the WRs (wide receivers)
    // TODO: problem: the attribute signature is the same as RBs.
    // private FootballPlayer(int receivingYards) {
    //     this.receivingYards = receivingYards;
    // }

    // for the DEF (defenders)
    private FootballPlayer(int totalTackles, int interceptions) {
        this.totalTackles = totalTackles;
        this.interceptions = interceptions;
    }

    // for the Kickers
    // TODO: problem: the attribute signature is the same as RBs.
    // private FootballPlayer(int fieldGoals) {
    //     this.fieldGoals = fieldGoals;
    // }

    // for the Punters
    private FootballPlayer(double avgPunt) {
        this.avgPunt = avgPunt;
    }

    // for the Special Teams
    private FootballPlayer(double avgKickoffReturn, double avgPuntReturn) {
        this.avgKickoffReturn = avgKickoffReturn;
        this.avgPuntReturn = avgPuntReturn;
    }

    public static void main(String[] args) {
        FootballPlayer sterlingKnight = new FootballPlayer(108.0, 259);
        System.out.println("Sterling Knight Passer Rating: " + sterlingKnight.getPasserRating());
    }
}
