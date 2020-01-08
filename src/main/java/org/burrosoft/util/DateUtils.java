package org.burrosoft.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT="yyyy/MM/dd";

    public String getFormattedCurrentDate(String urlPattern){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(urlPattern));
    }
    public String getFormattedDate(LocalDateTime dateTime, String urlPattern){
        return dateTime.format(DateTimeFormatter.ofPattern(urlPattern));
    }

}
