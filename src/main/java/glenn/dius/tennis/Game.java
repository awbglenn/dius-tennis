package glenn.dius.tennis;

import java.util.HashMap;

public class Game {

    private HashMap<String, String> playerScores;

    public Game(String player1, String player2) {

        playerScores = new HashMap<String, String>();
        playerScores.put(player1, "0");
        playerScores.put(player2, "0");

    }

    public String getScoreFromPlayer(String player) {
        return playerScores.get(player);
    }

    public void giveAPointTo(String player) {
        String newScore = calculateNewScore(playerScores.get(player));
        playerScores.put(player, newScore);
    }

    private String calculateNewScore(String oldScore){
        if (oldScore.equals("0")){
            return "15";
        }

        if (oldScore.equals("15")){
            return "30";
        }

        if (oldScore.equals("30")){
            return "40";
        }

        if (oldScore.equals("40")){

        }

        return null;
    }

    String getScore(String player1, String player2){
        String gameScore = getScoreFromPlayer(player1) + "-" + getScoreFromPlayer(player2);

        if(gameScore.equals("40-40")){
            return "Deuce";
        }

        return gameScore;
    }
}
