/** 
  Calculate Fibonacci number n
  3 implementations
  @precondition: n >= 1
  
  Use type "long" instead of "int", because rabbits.
 */

public class Fib {
    /** 
      @return the nth Fibonacci number
              by implementing the recurrence relation
     */
    public static long fib_recurrence( int n) {
		if(n < 3)
			return 1;
		else return fib_recurrence(n - 1) + fib_recurrence(n - 2);
    }
     /* These are class methods because it makes no sense to have an instance of
	 a fib object and expect these methods to act differently based on those instances.
	 
	 If one is unwilling to wait a few seconds, n of ~40 seems to be 
	 the highest
    */
	
    /** 
      @return the nth Fibonacci number
              calculated via the 8th-grade algorithm
     */
    public static long fib_grade8( int n) {
        long addingLeft     = n;
		long lastFibNum     = 1;
		long lastLastFibNum = 1;
		long currentFibNum  = 1;
		while(addingLeft > 2){
			 //System.out.println("addingLeft: " + addingLeft);
			 //System.out.println("lastFibNum: " +   lastFibNum);
			 //System.out.println("lastLastFibNum: " + lastLastFibNum);
			 //System.out.println("currentFibNum: " + currentFibNum);
			 lastLastFibNum = lastFibNum;
			 lastFibNum = currentFibNum;
			 currentFibNum = lastFibNum + lastLastFibNum;
			 addingLeft--;
		}
		return currentFibNum;
    }
    /* Time complexity:
       Consider the size of the problem to be n
       
       As the proxy for the time required, count math operations
       
       Then cost of the the recurrence algorithm
       grows exponentially
       as the size of the problem increases,
       because we need the last 2 numbers to solve for the nth term
	   and in order to solve the last 2 numbers we need to solve for
	   the last 2 numbers of those last two numbers and so on...
     */


    /** 
      @return the nth Fibonacci number
              calculated via Binet's formula.
              Type is double so that this exercise can
              ignore rounding issues.
     */
    public static double fib_Binet( int n) {
		double phi = (1 + Math.sqrt(5)) / 2;
		double psi = (1 - Math.sqrt(5)) / 2;
        //System.out.println(phi + " " + psi);
		return (Math.pow(phi, n) - Math.pow(psi, n)) / Math.sqrt(5);
    }
    /* Time complexity:
       Consider the size of the problem to be n
       
       As the proxy for the time required, count math operations
       
       Then cost of the the Binet algorithm
       is constant
       as the size of the problem increases,
       because there is always only 5 math operations.
     */
}
