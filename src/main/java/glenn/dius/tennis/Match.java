package glenn.dius.tennis;

public class Match {

    private Set set;

    private String player1;
    private String player2;
    private Game game;

    public Match(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        game  = new Game(player1, player2);
    }

    public String score() {
        return "0-0, " + game.getScore(player1, player2);
    }

    public void pointWonBy(String scoringPlayer) {
        game.giveAPointTo(scoringPlayer);
    }

}
