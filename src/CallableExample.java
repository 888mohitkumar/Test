import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableExample {
	public static void main(final String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// final ThreadPoolExecutor executor = (ThreadPoolExecutor)
		// Executors.newFixedThreadPool(2);

		final ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);

		final List<Future<Integer>> resultList = new ArrayList<>();

		final Random random = new Random();

		for (int i = 0; i < 4; i++) {
			final Integer number = random.nextInt(10);
			final FactorialCalculator calculator = new FactorialCalculator(number);
			final Future<Integer> future = newFixedThreadPool.submit(calculator);
			// result.get();
			future.get(); // Waits if necessary for the computation to complete,
							// and thenretrieves its result.
			final long timeout = 0;
			final TimeUnit unit = null;
			future.get(timeout, unit); // Waits if necessary for the computation
										// to complete, and thenretrieves its
										// result.
			final boolean mayInterruptIfRunning = false;
			future.cancel(mayInterruptIfRunning);// Attempts to cancel execution
													// of this task. This
													// attempt willfail if the
													// task has already
													// completed, has already
													// been cancelled,or could
													// not be cancelled for some
													// other reason. If
													// successful,and this task
													// has not started when
													// cancel is called,this
													// task should never run. If
													// the task has already
													// started,then the
													// mayInterruptIfRunning
													// parameter
													// determineswhether the
													// thread executing this
													// task should be
													// interrupted inan attempt
													// to stop the task. After
													// this method returns,
													// subsequent calls to
													// isDone willalways return
													// true. Subsequent calls to
													// isCancelledwill always
													// return true if this
													// method returned
													// true.Parameters:mayInterruptIfRunning
													// true if the thread
													// executing thistask should
													// be interrupted;
													// otherwise, in-progress
													// tasks are allowedto
													// complete
			future.isCancelled();// Returns true if this task was cancelled
									// before it completednormally.Returns:true
									// if this task was cancelled before it
									// completed
			future.isDone();// Returns true if this task was cancelled before it
							// completednormally.Returns:true if this task was
							// cancelled before it completed
			resultList.add(future);
		}

		for (final Future<Integer> future : resultList) {
			try {
				System.out.println(
						"Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// shut down the executor service now
		newFixedThreadPool.shutdown();
	}
}