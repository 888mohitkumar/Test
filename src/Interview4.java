import java.util.HashMap;

// An Enum class
enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

// Driver class that contains an object of "day" and
// main().
public class Interview4 {
	// Driver method
	public static void main(final String[] args) {
		final String str = "MONDAY";
		final Interview4 t1 = new Interview4(Day.valueOf(str));
		t1.dayIsLike();

		final Day d1 = Day.FRIDAY;
		final Day d2 = Day.SUNDAY;
		final HashMap hs = new HashMap<>();
		hs.put(d1, 1);
		hs.put(d2, 2);
		System.out.println(hs);

	}

	Day day;

	// Constructor
	public Interview4(final Day day) {
		this.day = day;
	}

	// Prints a line about Day using switch
	public void dayIsLike() {
		switch (day) {
		case MONDAY:
			System.out.println("Mondays are bad.");
			break;
		case FRIDAY:
			System.out.println("Fridays are better.");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			break;
		default:
			System.out.println("Midweek days are so-so.");
			break;
		}
	}
}