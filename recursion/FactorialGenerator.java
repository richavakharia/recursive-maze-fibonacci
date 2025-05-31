package recursion;

public class FactorialGenerator {

    public double nthFactorial(int n) {
        return computeFactorialRecurse(n);
    }

    
    private double computeFactorialRecurse(int n) {
        assert n >= 0 : "Factorial input cannot be negative: " + n;

        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return n * computeFactorialRecurse(n - 1); // Recursive call
        }
    }


    public static void main(String[] args) {
        FactorialGenerator generator = new FactorialGenerator();

        // Call nthFactorial() with interesting values
        int[] values = {6,10,20}; // Example interesting values
        //Exception in thread "main" java.lang.AssertionError: Factorial input cannot be negative: -1

        for (int value : values) {
            double result = generator.nthFactorial(value);
            System.out.println("Factorial of " + value + " is: " + result); 
      
        }
        
     // Print factorials for values of x from 1 to 32
        for (int x = 1; x <= 32; x++) {
            double result = generator.nthFactorial(x);
            System.out.println(x + "! = " + result);

         //looks wrong after 20, has negative numbers, due to stack overflow
            }
        
                //error compilation problem, static reference to a non static method
        System.out.println("Maximum value for long data type: " + Long.MAX_VALUE);
        //Maximum value for long data type: 9223372036854775807

        }
    

}
