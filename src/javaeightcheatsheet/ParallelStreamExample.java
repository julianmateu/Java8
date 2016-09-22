package javaeightcheatsheet;

import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ParallelStreamExample {
	private static final int N = 1000;
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(i);
		}
		long startTime = System.nanoTime();
		list.stream()
			.map(n -> new FactorialData(n));
//			.forEach(d -> System.out.println(d.log + " . " + d.factorial.x + "! = " + d.factorial.y));
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("The whole computation took " + elapsedTime/10e9 + " seconds.");
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
