import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java8 {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final Person p1 = new Person(100, "A");
		final Person p2 = new Person(101, "B");
		final Person p3 = new Person(102, "c");
		final Person p4 = new Person(103, "d");
		final Person p5 = new Person(104, "e");
		final Person p6 = new Person(105, "f");

		final List<Person> al = new ArrayList();
		al.add(p6);
		al.add(p5);
		al.add(p4);
		al.add(p3);
		al.add(p1);
		al.add(p2);

		System.out.println(al);

		final PersonComprator pc = new PersonComprator();

		Collections.sort(al, pc::compare22);
		System.out.println("first ::" + al);

		// Collections.sort(al, (a, b) -> a.id - b.id);
		// System.out.println("Second ::" + al);

		// Collections.sort(al, (a,b) -> pc.compare(a,b));
		// System.out.println("Third ::" + al);

		// Collections.sort(al, (o1, o2) -> o1.id - o2.id);

		// System.out.println(al);

		// final XYZ x = new XYZ();

		// Temp.temp(x::displayXyz);

		Temp.temp(() -> System.out.println("annonimous class style"));

		final MyI i = () -> System.out.println("annonimous class style");

		i.displayMyI();

		Temp.temp(() -> System.out.println("annonimous class style"));
		final MyI2 i2 = ArrayList::new;

		final MyI2 i3 = al1 -> {
			// TODO Auto-generated method stub

		};

		// final IntStream limit = IntStream.rangeClosed(0, 10).limit(10);
		// final IntStream distinct = limit.distinct();
		// distinct.forEach(System.out::println);
		// limit.forEach(System.out::println);

		// IntStream.range(10, 20).skip(5).forEach(System.out::println);

		// final long k = limit.count();
		// System.out.println(k);

		final ArrayList al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(5);
		al1.add(0);

	}

}

@FunctionalInterface
interface MyI {
	public void displayMyI();
}

@FunctionalInterface
interface MyI2 {
	public void displayMyI2(List al);
}

class Person {
	int id;
	String name;

	public Person(final int id, final String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}

class PersonComprator {

	public int compare22(final Person o1, final Person o2) {

		return o1.id - o2.id;
	}

}

class Temp {
	public static void temp(final MyI x) {
		// x.displayMyI();
	}
}

class XYZ {

	public void displayXyz() {
		System.out.println("xyz");
	}
}
