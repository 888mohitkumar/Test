import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class Interviews1 {

	public static void main(final String[] args) throws ParseException {
		final SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		final Date date1 = dateformat3.parse("17/07/1990");
		final Date date2 = dateformat3.parse("19/07/1995");
		final Date date3 = dateformat3.parse("21/07/1999");
		final Date date4 = dateformat3.parse("25/07/1991");
		final Date date5 = dateformat3.parse("25/07/2010");
		final Date date6 = dateformat3.parse("25/07/2025");
		final TreeSet<Date> dates = new TreeSet<>();

		dates.add(date1);
		dates.add(date2);
		dates.add(date3);
		dates.add(date4);
		dates.add(date5);
		dates.add(date6);
		System.out.println(dates);

		final Date d = new Date();

		final Date lower = dates.lower(d);
		final Date higher = dates.higher(d);

		Date nearest;
		if (lower == null || higher == null) {
			nearest = lower == null ? higher : lower;
		} else {
			final int i = d.compareTo(higher);
			final int j = d.compareTo(lower);
			if (Math.abs(i) > Math.abs(j)) {
				nearest = lower;
			} else {
				nearest = higher;
			}
		}

		System.out.println(lower);
		System.out.println(higher);

		System.out.println("-----------------");
		System.out.println(nearest);

	}

}
