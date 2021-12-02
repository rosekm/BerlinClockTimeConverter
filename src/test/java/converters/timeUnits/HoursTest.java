package converters.timeUnits;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Hours.class)
public class HoursTest {

    @Test
    public void shouldReturnAllLampsDisabledWhenHoursIs0(){
        Hours hours = new Hours();
        int hoursInput = 0;
        StringBuffer expectedHoursOutput = new StringBuffer();
        expectedHoursOutput.append("OOOO").append(System.lineSeparator());
        expectedHoursOutput.append("OOOO");

        String actualHoursOutput = hours.convertToBerlinClockHours(hoursInput);

        assertEquals(expectedHoursOutput.toString(),actualHoursOutput);
    }

    @Test
    public void shouldReturnAllLampsEnabledWhenHoursIs24(){
        Hours hours = new Hours();
        int hoursInput = 24;
        StringBuffer expectedHoursOutput = new StringBuffer();
        expectedHoursOutput.append("RRRR").append(System.lineSeparator());
        expectedHoursOutput.append("RRRR");

        String actualHoursOutput = hours.convertToBerlinClockHours(hoursInput);

        assertEquals(expectedHoursOutput.toString(),actualHoursOutput);
    }

    @Test
    public void shouldReturnHalfLampsEnabledWhenHoursIs12(){
        Hours hours = new Hours();
        int hoursInput = 12;
        StringBuffer expectedHoursOutput = new StringBuffer();
        expectedHoursOutput.append("RROO").append(System.lineSeparator());
        expectedHoursOutput.append("RROO");

        String actualHoursOutput = hours.convertToBerlinClockHours(hoursInput);

        assertEquals(expectedHoursOutput.toString(),actualHoursOutput);
    }
}