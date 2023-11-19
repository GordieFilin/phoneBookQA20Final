package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesUtils {

    public static String getDateString() {
        Date currentDate = new Date();
        // for windows:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        // for mac we can use format: yyyy-MM-dd_HH:mm:ss
        return dateFormat.format(currentDate);
    }
}
