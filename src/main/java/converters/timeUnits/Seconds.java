package converters.timeUnits;

public class Seconds {

    private StringBuffer berlinClockSeconds;

    public Seconds(){
        this.berlinClockSeconds = new StringBuffer();
    }

    public String convertToBerlinClockSec(int secondsValue){
        berlinClockSeconds.setLength(0);
        berlinClockSeconds.append(secondsValue%2 == 0 ? "Y" : "O");
        return berlinClockSeconds.toString();
    }
}

