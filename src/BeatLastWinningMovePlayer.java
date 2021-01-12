public class BeatLastWinningMovePlayer implements Player {
    private int winningLastMove;

    public BeatLastWinningMovePlayer() {
        winningLastMove = RPS.ROCK;		// we'll start by trying to beat rock
    }

    public int getMove() {
       if (winningLastMove == RPS.ROCK) { return RPS.PAPER; }
       else if (winningLastMove == RPS.PAPER) { return RPS.SCISSORS; }
       else { return RPS.ROCK; }
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        winningLastMove = outcome == RPS.P1 ? yourMove : opponentMove;
    }
}

