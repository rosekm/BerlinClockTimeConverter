package converters.BerlinClockTimeConverter;

import converters.validators.StandardTimeFormatValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class BerlinClockTimeConverterApi {

    private BerlinClockTimeConverter converter;
    private StandardTimeFormatValidator validator;

    @Autowired
    public BerlinClockTimeConverterApi(BerlinClockTimeConverter converter, StandardTimeFormatValidator validator) {
        this.converter = converter;
        this.validator = validator;
    }

    @GetMapping("/berlinClock")
    public String convertTime(@RequestParam String time) {
        if (validateInputFormat(time)) {
            return converter.convertTime(time);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateInputFormat(String aTime) {
        return validator.timeHasValidFormat(aTime);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity showInvalidInputMessage() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}
