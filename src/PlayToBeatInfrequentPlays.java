import java.util.ArrayList;

public class PlayToBeatInfrequentPlays implements Player {
    int n; // number of last moves to remember
    ArrayList<Integer> opponentLastMoves;
    int num_games = 0;

    public PlayToBeatInfrequentPlays(int n) {
        this.n = n;
        opponentLastMoves = new ArrayList<>();
    }

    public int getMove() {
        if (num_games < n) { return randMove(); }
        return beat( mostInfrequentPlay() );
    }

    private int beat(int move) {
        if ( move == RPS.ROCK ) { return RPS.PAPER; }
        else if ( move == RPS.PAPER ) { return RPS.SCISSORS; }
        else return RPS.ROCK;
    }

    private int mostInfrequentPlay() {
        int[] moves = new int[3];
        for (Integer move : opponentLastMoves) {
            moves[ move ]++;
        }
        if (moves[RPS.ROCK] < moves[RPS.SCISSORS] && moves[RPS.ROCK] < moves[RPS.PAPER]) { return RPS.ROCK; }
        else if (moves[RPS.PAPER] < moves[RPS.SCISSORS] && moves[RPS.PAPER] < moves[RPS.ROCK]) { return RPS.PAPER; }
        else { return RPS.SCISSORS; }
    }

    private int randMove() {
        int num = (int)(Math.random()*3);
        if (num == 0) return RPS.ROCK;
        if (num == 1) return RPS.PAPER;
        return RPS.SCISSORS;
    }


    public void updateLastRoundInfo(int yourMove, int opponentMove, int outcome) {
        num_games++;
        opponentLastMoves.add( opponentMove );
        if (opponentLastMoves.size() > n) {
            opponentLastMoves.remove(0);
        }
    }
}

