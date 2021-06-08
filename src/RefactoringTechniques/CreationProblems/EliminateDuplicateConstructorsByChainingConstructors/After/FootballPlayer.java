package RefactoringTechniques.CreationProblems.EliminateDuplicateConstructorsByChainingConstructors.After;

class FootballPlayer {

    private String playerName = "";
    private String college = "";
    private double fortyYardDash = 0.0;
    private int repsBenchPress = 0;
    private double sixtyYardDash = 0.0;

    private String getPlayerName() {
        return playerName;
    }
    private String getCollege() {
        return college;
    }
    private double getFortyYardDash() {
        return fortyYardDash;
    }
    private int getRepsBenchPress() {
        return repsBenchPress;
    }
    private double getSixtyYardDash() {
        return sixtyYardDash;
    }

    // A catchall constructor for the parameters playerName, college, and fortyYardDash.

    private FootballPlayer(String playerName, String college,
                          double fortyYardDash, int repsBenchPress,
                          double sixtyYardDash) {
        this.playerName = playerName;
        this.college = college;
        this.fortyYardDash = fortyYardDash;
        this.repsBenchPress = repsBenchPress;
        this.sixtyYardDash = sixtyYardDash;
    }

    private FootballPlayer(String playerName, String college,
                          double fortyYardDash, int repsBenchPress) {
        this(playerName, college, fortyYardDash,
             repsBenchPress, 0.0);
    }

    private FootballPlayer(String playerName, String college,
                          double fortyYardDash, double sixtyYardDash) {
        this(playerName, college, fortyYardDash,
                0, sixtyYardDash);
    }

    public static void main(String[] args) {
        FootballPlayer sonicTheHedgeHog =
                new FootballPlayer("Sonic the HedgeHog", "Harvard",
                        4.53, 10.75);
        System.out.println(sonicTheHedgeHog.getPlayerName());
        System.out.println(sonicTheHedgeHog.getCollege());
        System.out.println(sonicTheHedgeHog.getFortyYardDash());
        System.out.println(sonicTheHedgeHog.getRepsBenchPress());
        System.out.println(sonicTheHedgeHog.getSixtyYardDash());
    }
}
