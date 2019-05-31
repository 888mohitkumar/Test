import java.util.Arrays;
import java.util.List;

class EmpLoyee {
	static String name = "RAM";

	public static void showName(final String x) {
		System.out.println(x);
	}

	public void template(final String str) {
		System.out.println("here templete function body :" + str);
	}
}

@FunctionalInterface
interface MyInterface {
	void sisplay(String str);
}

public class Test {

	public static void display(final EmpLoyee e) {

	}

	public static void main(final String[] args) throws InterruptedException {
		System.out.println("Test ::::::::::::::");
		final List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
		// messages.forEach(a -> StringUtils.capitalize(a));
		// messages.forEach(a -> System.out.println(a));
		messages.forEach(System.out::println);
		// final MyInterface my = (x) -> EmpLoyee.showName(x);
		final MyInterface my = EmpLoyee::showName;
		my.sisplay("kk");

		final EmpLoyee e = new EmpLoyee();
		// final MyInterface my1 = (x) -> e.template(x);
		final MyInterface my1 = e::template;
		// my1.sisplay("zzz");
		System.out.println("Pagal");
	}
}
