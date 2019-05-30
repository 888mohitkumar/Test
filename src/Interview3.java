import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

class Employee1 implements Comparable<Employee1> {
	int id;
	String name;

	public Employee1(final int id, final String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(final Employee1 e) {
		return id - e.id;
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
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}

public class Interview3 {

	public static void main(final String[] args) {
		final HashMap hm = new HashMap();
		/*
		 * hm.put(1, "A"); hm.put(2, "B"); hm.put(3, "C"); hm.put(4, "D");
		 * hm.put(5, "E");
		 */
		final Employee1 e1 = new Employee1(1, "A");
		final Employee1 e2 = new Employee1(2, "B");
		final Employee1 e3 = new Employee1(3, "C");

		hm.put(e1, 1);
		hm.put(e2, 2);
		hm.put(e3, 3);

		// final TreeSet ts = new TreeSet();
		// ts.add(hm);

		final TreeMap tm = new TreeMap();
		tm.putAll(hm);
		/*
		 * hm.put("a", 1); hm.put("b", 2); hm.put("c", 3); hm.put("D", 4);
		 */
		// System.out.println(tm);
		// System.out.println(hm);

		final ArrayList al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);

		final CopyOnWriteArrayList<Integer> cowal = new CopyOnWriteArrayList<>(al);

		final Iterator iterator = al.iterator();
		while (iterator.hasNext()) {
			// al.add(1, 11);
			al.set(1, 11);
			;
			System.out.println(iterator.next());
		}

		Executors.newSingleThreadExecutor();

	}

}
