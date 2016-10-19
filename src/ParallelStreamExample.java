
import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class ParallelStreamExample {
	private static final int N = 5000;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(i);
		}
		long startTime = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
		forkJoinPool.submit(() ->
			list.parallelStream()
				.map(n -> new FactorialData(n))//.collect(Collectors.toList())
				.forEach(d -> System.out.println(d.log + " . " + d.factorial.x + "! = " + d.factorial.y))
		).get();

		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("The whole computation took " + elapsedTime/10e3 + " seconds.");
	}
	
	/**
	 * A class to hold a number, its factorial, and some information about the computation.
	 * 
	 * @author jmateu
	 *
	 */
	public static class FactorialData {
		// A tuple of the number and the result of its factorial:
		public Tuple<Integer, BigInteger> factorial;
		// A log with the information of the thread and process in which the computation is done:
		public String log;
		
		public FactorialData(Integer n) {
			factorial = new Tuple<Integer, BigInteger>(n, factorial(n));
			log = new String("Calling factorial(" + n + ") on thread " 
					+ Thread.currentThread().getName() + " on process " + ManagementFactory.getRuntimeMXBean().getName());
		}
		
		public static BigInteger factorial(Integer n) {
			if (n.equals(new Integer(0))) return BigInteger.valueOf(1);
			return factorial(Integer.sum(n, -1)).multiply(BigInteger.valueOf(n));
		}
		
		/**
		 * Auxiliary class to represent a tuple of two objects.
		 */
		public static class Tuple<X, Y> { 
			public final X x; 
			public final Y y; 
			public Tuple(X x, Y y) { 
				this.x = x; 
				this.y = y; 
			} 
		} 
	}
}
