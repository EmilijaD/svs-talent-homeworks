import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

	private static final int NUMBER_OF_OPERATIONS = 10;

	public static void main(String[] args) throws Exception {

		final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
		final ExecutorService executorService = Executors.newCachedThreadPool();
		Integer max;
		ArrayList<Future<Integer>> complexCalculationFuture = new ArrayList<Future<Integer>>();
		ArrayList<Integer> number = new ArrayList<Integer>();
		for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
			complexCalculationFuture.add(executorService
					.submit(new ComplexCalculation(latch)));

		}
		for (int j = 1; j < NUMBER_OF_OPERATIONS; j++) {
			Integer complexCalculationResult = complexCalculationFuture.get(j)
					.get();
			number.add(complexCalculationResult);
			System.out.println(complexCalculationResult);
		}

		max = number.get(0);

		for (int i = 0; i < number.size(); i++) {
			if (max < number.get(i))
				max = number.get(i);

		}
		System.out.println("Max e: " + max);

		executorService.shutdown();
	}
}
