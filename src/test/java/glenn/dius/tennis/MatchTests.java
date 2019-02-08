package glenn.dius.tennis;


import org.junit.jupiter.api.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatchTests {

    @Test
    public void intitialScoreShouldBeZeroZero(){
        Match match = new Match("player 1", "player 2");
        String result = match.score();
        assertThat(result, is("0-0, 0-0"));
    }



}
