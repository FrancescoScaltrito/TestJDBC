package utilities;

import java.sql.Date;
import java.time.LocalDate;

public class Utilities {
	public static LocalDate dateToLocalDate(Object value){
		if(value==null) return null;
		return ((Date)value).toLocalDate();
	}
}
