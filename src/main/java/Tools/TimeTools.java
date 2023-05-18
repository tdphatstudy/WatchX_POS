package Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {
    public String convertDateToString(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        return formatter.format(date);
    }
}
