import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ComplexCalculation implements Callable<Integer> {
 CountDownLatch latch;
 
	public ComplexCalculation(CountDownLatch latch) {
	super();
	this.latch = latch;
}

	@Override
	public Integer call() throws Exception {
		  
			return new Random().nextInt(10 + 1);
		
		
	}

}
