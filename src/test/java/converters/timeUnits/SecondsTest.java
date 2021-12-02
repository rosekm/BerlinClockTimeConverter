package converters.timeUnits;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Seconds.class)
public class SecondsTest {

    @Test
    public void shouldReturnDisabledLampWhenOddSecValue(){
        Seconds seconds = new Seconds();
        int inputSecondValue = 11;
        StringBuffer expectedSecondsOutput = new StringBuffer();
        expectedSecondsOutput.append("O");

        String actualSecondsOutput = seconds.convertToBerlinClockSec(inputSecondValue);

        assertEquals(expectedSecondsOutput.toString(),actualSecondsOutput);
    }

    @Test
    public void shouldReturnEnabledLampWhenEvenSecValue(){
        Seconds seconds = new Seconds();
        int inputSecondValue = 10;
        StringBuffer expectedSecondsOutput = new StringBuffer();
        expectedSecondsOutput.append("Y");

        String actualSecondsOutput = seconds.convertToBerlinClockSec(inputSecondValue);

        assertEquals(expectedSecondsOutput.toString(),actualSecondsOutput);
    }

}