import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author agung 1972050
 */
import java.text.ParseException;

public class TimeConverter {
    private int second;
    public TimeConverter(){

    }
    public TimeConverter(int second){
        this.second=second;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = Math.abs(second);
    }
    public String showTime() throws ParseException {
        int jam= second/3600;
        int sisaJam=second-jam*3600;
        int min=sisaJam/60;
        int sisaMin=sisaJam-min*60;
        String jamStr = String.valueOf(jam);
        String minStr = String.valueOf(min);
        String secStr = String.valueOf(sisaMin);
        String wkt=jamStr+":"+minStr+":"+secStr;
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = SimpleDateFormat.parse(wkt);
        String dateStr=SimpleDateFormat.format(date);
        return dateStr;
    }
}
