package glenn.dius.tennis;


import org.junit.jupiter.api.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatchTests {

    @Test
    public void initialScoreShouldBeZeroZero(){
        Match match = new Match("player 1", "player 2");
        String result = match.score();
        assertThat(result, is("0-0, 0-0"));
    }

    @Test
    public void scoreAfterPlayer1ScoresFirstShouldBeOneZero(){
        Match match = new Match("player 1", "player 2");
        match.pointWonBy("player 1");
        String result = match.score();
        assertThat(result, is("0-0, 15-0"));
    }

    @Test
    public void scoreAfterPlayer2ScoresFirstShouldBeOneZero(){
        Match match = new Match("player 1", "player 2");
        match.pointWonBy("player 2");
        String result = match.score();
        assertThat(result, is("0-0, 0-15"));
    }

    @Test
    public void scoreAfterBothPlayersScoreOnceShouldBe1515(){
        Match match = new Match("player 1", "player 2");
        match.pointWonBy("player 1");
        match.pointWonBy("player 2");

        String result = match.score();
        assertThat(result, is("0-0, 15-15"));
    }

    @Test
    public void scoreAfterPlayer1ScoresTwiceShouldBe30(){
        Match match = new Match("player 1", "player 2");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        String result = match.score();
        assertThat(result, is("0-0, 30-0"));
    }

    @Test
    public void scoreAfterPlayer2ScoresTwiceShouldBe30(){
        Match match = new Match("player 1", "player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        String result = match.score();
        assertThat(result, is("0-0, 0-30"));
    }

    @Test
    public void scoreAfterPlayer1ScoresThreeTimesShouldBe40(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        String result = match.score();
        assertThat(result, is("0-0, 40-0"));
    }

    @Test
    public void scoreIfBothPlayersAreTiedAt40ShouldBeDeuce(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");


        String result = match.score();
        assertThat(result, is("0-0, Deuce"));
    }

    @Test
    public void scoreAfterDeuceIfPlayer1ScoresShouldGiveTheAdvantageToThem(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 1");


        String result = match.score();
        assertThat(result, is("0-0, Deuce, Advantage player 1"));
    }

    @Test
    public void scoreAfterDeuceIfPlayer2ScoresShouldGiveTheAdvantageToThem(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 2");


        String result = match.score();
        assertThat(result, is("0-0, Deuce, Advantage player 2"));
    }


}
