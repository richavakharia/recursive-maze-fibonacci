package recursion;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FibGenerator {
	
	
	public int nthFib(int n) {
		Logger.getGlobal().info("Entering fib. n=" + n);
		Logger.getGlobal().info("Exiting fib. return=" + computeFibRecurse(n));

		return computeFibRecurse(n);

	}
	
	private int computeFibRecurse(int n) {
		if (n <= 2) {
			return 1;
		}
		
		else {
			int first = computeFibRecurse(n-1);
				int second = computeFibRecurse(n-2);
				return first + second;
			}

	}
	
	public static void main (String[] args) {
		System.out.println("STARTING");
		FibGenerator generator = new FibGenerator();
		int value = generator.nthFib(5);
		System.out.println("Input of 5: " + value);
		int value2 = generator.nthFib(10);
		System.out.println("Input of 10: " + value2);
		int value3 = generator.nthFib(15);
		System.out.println("Input of 15: " + value3);
		
		
		
		for (int x = 1; x <= 20; x++) {
            int result = generator.nthFib(x);
            System.out.println("fib(" + x + ") = " + result);

            }
        
		for (int x = 20; x <= 30; x++) {
            int result = generator.nthFib(x);
            System.out.println("fib(" + x + ") = " + result);

            }
		//runs slowly starting here because theres more recursive calls as the number gets bigger
		for (int x = 40; x <= 50; x++) {
            int result = generator.nthFib(x);
            System.out.println("fib(" + x + ") = " + result);

            }
		
		for (int x = 50; x <= 60; x++) {
            int result = generator.nthFib(x);
            System.out.println("fib(" + x + ") = " + result);

            }
		
		Logger.getGlobal().setLevel(Level.OFF);

	}

}
