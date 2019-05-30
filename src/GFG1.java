import java.util.Optional;

class GFG1 {

	// Driver code
	public static void main(final String[] args) {

		// creating a string array
		final String[] str = new String[5];

		// Setting value for 2nd index
		str[2] = "Geeks Classes are coming soon";

		// It returns an empty instance of Optional class
		final Optional<String> empty = Optional.empty();
		System.out.println(empty);

		// It returns a non-empty Optional
		final Optional<String> value = Optional.ofNullable(str[2]);
		System.out.println(value.isPresent());
		value.ifPresent(t -> System.out.println("hello :" + t));
		value.orElse("other");
		System.out.println(value);
		System.out.println(value.get());

	}
}