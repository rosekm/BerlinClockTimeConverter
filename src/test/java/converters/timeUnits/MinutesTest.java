package converters.timeUnits;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Minutes.class)
public class MinutesTest {

    @Test
    public void shouldReturnAllLampsDisabledWhenMinutesIs0(){
        Minutes minutes = new Minutes();
        int minutesInput = 0;
        StringBuffer expectedMinutesOutput = new StringBuffer();
        expectedMinutesOutput.append("OOOOOOOOOOO").append(System.lineSeparator());
        expectedMinutesOutput.append("OOOO");

        String actualMinutesOutput = minutes.convertToBerlinClockMinutes(minutesInput);

        assertEquals(expectedMinutesOutput.toString(),actualMinutesOutput);
    }

    @Test
    public void shouldReturnAllLampsEnabledWhenMinutesIs59(){
        Minutes minutes = new Minutes();
        int minutesInput = 59;
        StringBuffer expectedMinutesOutput = new StringBuffer();
        expectedMinutesOutput.append("YYRYYRYYRYY").append(System.lineSeparator());
        expectedMinutesOutput.append("YYYY");

        String actualMinutesOutput = minutes.convertToBerlinClockMinutes(minutesInput);

        assertEquals(expectedMinutesOutput.toString(),actualMinutesOutput);
    }

    @Test
    public void shouldReturnPartLampsEnabledWhenMinutesIs43(){
        Minutes minutes = new Minutes();
        int minutesInput = 43;
        StringBuffer expectedMinutesOutput = new StringBuffer();
        expectedMinutesOutput.append("YYRYYRYYOOO").append(System.lineSeparator());
        expectedMinutesOutput.append("YYYO");

        String actualMinutesOutput = minutes.convertToBerlinClockMinutes(minutesInput);

        assertEquals(expectedMinutesOutput.toString(),actualMinutesOutput);
    }

}