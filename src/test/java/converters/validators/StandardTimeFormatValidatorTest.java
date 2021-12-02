package converters.validators;

import converters.timeUnits.Hours;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StandardTimeFormatValidator.class)
public class StandardTimeFormatValidatorTest {

    @Test
    public void shouldReturnTrueWhenInputTimeFormatMatchPattern(){
        StandardTimeFormatValidator validator = new StandardTimeFormatValidator();
        String inputTime = "11:11:11";

        assertEquals(true,validator.timeHasValidFormat(inputTime));
    }

    @Test
    public void shouldReturnFalseWhenTimeFormatNotMatchPattern(){
        StandardTimeFormatValidator validator = new StandardTimeFormatValidator();
        String inputTime = "111111";

        assertEquals(false,validator.timeHasValidFormat(inputTime));
    }

    @Test
    public void shouldReturnFalseWhenInputTimeIsEmpty(){
        StandardTimeFormatValidator validator = new StandardTimeFormatValidator();
        String inputTime = "";

        assertEquals(false,validator.timeHasValidFormat(inputTime));
    }

    @Test
    public void shouldReturnFalseWhenInputTimeIsNull(){
        StandardTimeFormatValidator validator = new StandardTimeFormatValidator();
        String inputTime = null;

        assertEquals(false,validator.timeHasValidFormat(inputTime));
    }
}