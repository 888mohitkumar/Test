import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {

	private final Integer number;

	public FactorialCalculator(final Integer number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int result = 1;
		if (number == 0 || number == 1) {
			result = 1;
		} else {
			for (int i = 2; i <= number; i++) {
				result *= i;
				Thread.sleep(1000);
			}
		}
		System.out.println("Result for number - " + number + " -> " + result);
		return result;
	}
}
