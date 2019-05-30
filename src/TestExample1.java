
import java.util.Arrays;
import java.util.stream.Stream;

public class TestExample1 {

	public static void main(final String[] args) {

		final String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		// Stream<String[]>
		final Stream<String[]> temp = Arrays.stream(data);

		// Stream<String>, GOOD!
		// final Stream<String> stringStream = temp.flatMap(x ->
		// Arrays.stream(x));
		final Stream<String> stringStream = temp.flatMap(x -> Stream.of(x));
		stringStream.forEach(System.out::println);

		// final Stream<String> stream = stringStream.filter(x ->
		// "a".equals(x.toString()));

		// stream.forEach(System.out::println);

		/*
		 * Stream<String> stream = Arrays.stream(data) .flatMap(x ->
		 * Arrays.stream(x)) .filter(x -> "a".equals(x.toString()));
		 */

	}

}