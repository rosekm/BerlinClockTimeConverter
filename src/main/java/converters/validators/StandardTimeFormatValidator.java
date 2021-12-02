package converters.validators;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StandardTimeFormatValidator {

    Pattern timePattern;
    Matcher matcher;

    public StandardTimeFormatValidator(){
        timePattern = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
    }

    public boolean timeHasValidFormat(String aTime){
        if(StringUtils.isNotEmpty(aTime)){
            matcher = timePattern.matcher(aTime);
            return matcher.matches();
        }else{
            return false;
        }

    }
}
