package glenn.dius.tennis;

import org.junit.jupiter.api.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTests {

    @Test
    public void getInitialPlayerScores(){

        Game game = new Game("player 1", "player 2");
        String result1 = game.getScoreFromPlayer("player 1");
        String result2 = game.getScoreFromPlayer("player 2");

        assertThat(result1, is("0"));
        assertThat(result2, is("0"));

    }

    @Test
    public void addScoreOnceToPlayer1(){
        Game game = new Game("player 1", "player 2");
        game.giveAPointTo("player 1");
        String result = game.getScoreFromPlayer("player 1");
        assertThat(result, is("15"));
    }

    @Test
    public void addScoreOnceToPlayer2(){
        Game game = new Game("player 1", "player 2");
        game.giveAPointTo("player 2");
        String result = game.getScoreFromPlayer("player 2");
        assertThat(result, is("15"));
    }

    @Test
    public void addScoreOnceToBothPlayers(){
        Game game = new Game("player 1", "player 2");

        game.giveAPointTo("player 1");
        String result1 = game.getScoreFromPlayer("player 1");
        assertThat(result1, is("15"));

        game.giveAPointTo("player 2");
        String result2 = game.getScoreFromPlayer("player 2");
        assertThat(result2, is("15"));
    }

    @Test
    public void addScoreTwiceToPlayer1(){
        Game game = new Game("player 1", "player 2");
        game.giveAPointTo("player 1");
        game.giveAPointTo("player 1");
        String result = game.getScoreFromPlayer("player 1");
        assertThat(result, is("30"));
    }

}
