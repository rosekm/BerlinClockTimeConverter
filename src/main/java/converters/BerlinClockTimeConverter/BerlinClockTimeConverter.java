package converters.BerlinClockTimeConverter;

import converters.timeUnits.Hours;
import converters.timeUnits.Minutes;
import converters.timeUnits.Seconds;
import converters.validators.StandardTimeFormatValidator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class BerlinClockTimeConverter {

    private StringBuffer berlinClockFormatTime;
    private Seconds seconds;
    private Hours hours;
    private Minutes minutes;
    private StandardTimeFormatValidator inputTimeValidator;


    public BerlinClockTimeConverter() {
        berlinClockFormatTime = new StringBuffer();
        seconds = new Seconds();
        hours = new Hours();
        minutes = new Minutes();
        inputTimeValidator = new StandardTimeFormatValidator();

    }

    public synchronized String convertTime(String aTime) {

        if(inputTimeValidator.timeHasValidFormat(aTime)) {
            berlinClockFormatTime.setLength(0);
            int[] timeUnitsValues = Stream.of(aTime.split(":")).mapToInt(unit -> Integer.parseInt(unit)).toArray();

            berlinClockFormatTime.append(seconds.convertToBerlinClockSec(timeUnitsValues[2]));
            berlinClockFormatTime.append(System.lineSeparator());
            berlinClockFormatTime.append(hours.convertToBerlinClockHours(timeUnitsValues[0]));
            berlinClockFormatTime.append(System.lineSeparator());
            berlinClockFormatTime.append(minutes.convertToBerlinClockMinutes(timeUnitsValues[1]));

            return berlinClockFormatTime.toString();

        } else{
            throw new IllegalArgumentException();
        }
    }
}
