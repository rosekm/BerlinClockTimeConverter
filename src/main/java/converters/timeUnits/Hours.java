package converters.timeUnits;

public class Hours {

    private StringBuffer berlinClockHours;
    private int hoursValue;

    public Hours(){
        this.berlinClockHours = new StringBuffer();
    }

    public String convertToBerlinClockHours(int hoursValue){
        berlinClockHours.setLength(0);
        this.hoursValue = hoursValue;
        createAndAppendHourIntervalsLine();
        berlinClockHours.append(System.lineSeparator());
        createAndAppendSingleHoursLine();
        return berlinClockHours.toString();
    }

    private void createAndAppendHourIntervalsLine(){
        for(int i = 0; i <4; i++){
            berlinClockHours.append(i< hoursValue/5 ? 'R' : 'O');
        }
    }

    private void createAndAppendSingleHoursLine(){
        for(int i = 0; i <4; i++){
            berlinClockHours.append(i< hoursValue%5 ? 'R' : 'O');
        }
    }
}
