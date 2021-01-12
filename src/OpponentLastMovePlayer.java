public class OpponentLastMovePlayer implements Player {
    int opponentLastMove;

    public OpponentLastMovePlayer() {
        opponentLastMove = RPS.ROCK;		// we'll start by trying to beat rock
    }

    public int getMove() {
        return opponentLastMove;
    }

    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        opponentLastMove = opponentMove;
    }
}

