public class BeatByFrequency implements Player {
    int[] opponentLastMove;
    int num_games = 0;

    public BeatByFrequency() {
        opponentLastMove = new int[3];
    }

    public int getMove() {
        displayStats();
        double rand = Math.random() * num_games;
        if ( rand < opponentLastMove[ RPS.ROCK ] ) { return RPS.PAPER; }
        else if (rand < opponentLastMove[ RPS.ROCK ] + opponentLastMove[ RPS.PAPER ] ) { return RPS.SCISSORS; }
        else return RPS.ROCK;
    }

    private void displayStats() {
        System.out.println(" #=" + num_games +
                           " R=" + opponentLastMove[RPS.ROCK] +
                           " P=" + opponentLastMove[RPS.PAPER] +
                           " S=" + opponentLastMove[RPS.SCISSORS]);
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        num_games++;
        opponentLastMove[ opponentMove ]++;
    }
}

