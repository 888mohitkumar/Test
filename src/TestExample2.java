import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Student {

	private String name;
	private Set<String> book;

	public void addBook(final String book) {
		if (this.book == null) {
			this.book = new HashSet<>();
		}
		this.book.add(book);
	}
	// getters and setters

	public Set<String> getBook() {
		return book;
	}

	public String getName() {
		return name;
	}

	public void setBook(final Set<String> book) {
		this.book = book;
	}

	public void setName(final String name) {
		this.name = name;
	}

}

public class TestExample2 {

	public static void main(final String[] args) {

		final Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		final Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		final List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		/*
		 * final List<String> collect = list.stream().map(x -> x.getBook()) //
		 * Stream<Set<String>> .flatMap(x -> x.stream()) // Stream<String>
		 * .collect(Collectors.toList());
		 */

		final List<String> collect = list.stream().map(x -> x.getBook()) // Stream<Set<String>>
				.flatMap(x -> x.stream()) // Stream<String>
				.collect(Collectors.toList());

		collect.forEach(x -> System.out.println(x));

	}
}
