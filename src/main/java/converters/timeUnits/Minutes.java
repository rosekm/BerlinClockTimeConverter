package converters.timeUnits;

public class Minutes {

    private StringBuffer berlinClockMinutes;
    private int minutesValue;

    public Minutes(){
        this.berlinClockMinutes = new StringBuffer();
    }


    public String convertToBerlinClockMinutes(int minutesValue) {
        this.berlinClockMinutes.setLength(0);
        this.minutesValue = minutesValue;
        createAndAppendMinuteIntervalsLine();
        berlinClockMinutes.append(System.lineSeparator());
        createAndAppendSingleMinutesLine();
        return berlinClockMinutes.toString();
    }

    private void createAndAppendMinuteIntervalsLine() {
        for (int i = 0; i < minutesValue / 15; i++) {
            berlinClockMinutes.append("YYR");
        }
        for (int i = (minutesValue / 15) * 3; i < 11; i++) {
            berlinClockMinutes.append(i < minutesValue / 5 ? 'Y' : 'O');
        }

    }

    private void createAndAppendSingleMinutesLine() {
        for (int i = 0; i < 4; i++) {
            berlinClockMinutes.append(i < minutesValue % 5 ? 'Y' : 'O');
        }
    }
}
