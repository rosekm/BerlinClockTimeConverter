package converters.BerlinClockTimeConverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BerlinClockTimeConverterTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputTimeIsNull(){
        BerlinClockTimeConverter timeConverter = new BerlinClockTimeConverter();
        String inputTime = null;

        timeConverter.convertTime(inputTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIncorrectInputFormat(){
        BerlinClockTimeConverter timeConverter = new BerlinClockTimeConverter();
        String inputTime = "2313sfd";

        String result = timeConverter.convertTime(inputTime);
    }

    @Test
    public void shouldReturnOnlySecondsLampEnabledWhenMinTimeInput(){
        BerlinClockTimeConverter timeConverter = new BerlinClockTimeConverter();
        String inputTime = "00:00:00";
        StringBuffer expectedOutputTime = new StringBuffer();
        expectedOutputTime.append("Y").append(System.lineSeparator());
        expectedOutputTime.append("OOOO").append(System.lineSeparator());
        expectedOutputTime.append("OOOO").append(System.lineSeparator());
        expectedOutputTime.append("OOOOOOOOOOO").append(System.lineSeparator());
        expectedOutputTime.append("OOOO");

        assertEquals(expectedOutputTime.toString(),timeConverter.convertTime(inputTime));

    }

    @Test
    public void shouldReturnMostLampsEnabledWhenTimeIs235959(){
        BerlinClockTimeConverter timeConverter = new BerlinClockTimeConverter();
        String inputTime = "23:59:59";
        StringBuffer expectedOutputTime = new StringBuffer();
        expectedOutputTime.append("O").append(System.lineSeparator());
        expectedOutputTime.append("RRRR").append(System.lineSeparator());
        expectedOutputTime.append("RRRO").append(System.lineSeparator());
        expectedOutputTime.append("YYRYYRYYRYY").append(System.lineSeparator());
        expectedOutputTime.append("YYYY");

        assertEquals(expectedOutputTime.toString(),timeConverter.convertTime(inputTime));
    }

    @Test
    public void shouldReturnAllHourLampsEnabledWhenMaxTimeInput(){
        BerlinClockTimeConverter timeConverter = new BerlinClockTimeConverter();
        String inputTime = "24:00:00";
        StringBuffer expectedOutputTime = new StringBuffer();
        expectedOutputTime.append("Y").append(System.lineSeparator());
        expectedOutputTime.append("RRRR").append(System.lineSeparator());
        expectedOutputTime.append("RRRR").append(System.lineSeparator());
        expectedOutputTime.append("OOOOOOOOOOO").append(System.lineSeparator());
        expectedOutputTime.append("OOOO");

        String result = timeConverter.convertTime(inputTime);

        assertEquals(expectedOutputTime.toString(),timeConverter.convertTime(inputTime));
    }

    @Test
    public void shouldReturnPartHourLampsEnabledWhenTimeIs172348(){
        BerlinClockTimeConverter timeConverter = new BerlinClockTimeConverter();
        String inputTime = "17:23:48";
        StringBuffer expectedOutputTime = new StringBuffer();
        expectedOutputTime.append("Y").append(System.lineSeparator());
        expectedOutputTime.append("RRRO").append(System.lineSeparator());
        expectedOutputTime.append("RROO").append(System.lineSeparator());
        expectedOutputTime.append("YYRYOOOOOOO").append(System.lineSeparator());
        expectedOutputTime.append("YYYO");

        String result = timeConverter.convertTime(inputTime);

        assertEquals(expectedOutputTime.toString(),timeConverter.convertTime(inputTime));
    }

}