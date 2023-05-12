package sbu.cs.CalculatePi;



    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     * Experiment with different algorithms to find accurate results.
     * <p>
     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.
     *
     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

public class PiCalculator {
    static BigDecimal answer = BigDecimal.ZERO;

    public static class PI implements Runnable {
        BigDecimal d;
        int floatingPoint;


        public PI(BigDecimal d, int floatingPoint ) {
            this.d = d;
            this.floatingPoint = floatingPoint;
        }

        public void run() {
            BigDecimal factorialD = factorial(d.intValue());
            factorialD = factorialD.pow(2);
            BigDecimal powTerm = BigDecimal.valueOf(2).pow(d.intValue() + 1);
            BigDecimal numerator = factorialD.multiply(powTerm);
            BigDecimal denominator = factorial((2 * d.intValue()) + 1);
            BigDecimal result = numerator.divide(denominator, floatingPoint + 2, RoundingMode.DOWN);
            sumInc(result);
        }
    }

    public static BigDecimal factorial(int n) {
        if (n == 0) {
            return BigDecimal.valueOf(1);
        } else {
            return BigDecimal.valueOf(n).multiply(factorial(n - 1));
        }
    }

    public static synchronized void sumInc(BigDecimal d) {
        answer = answer.add(d);
    }

    public static String calculate(int floatingPoint) {
        answer = BigDecimal.ZERO;
        ExecutorService threadPool = Executors.newCachedThreadPool();

        int i=0;
        while (i<floatingPoint*4){
            PI runnable = new PI(BigDecimal.valueOf(i),floatingPoint);
            threadPool.execute(runnable);
            i++;
        }
        threadPool.shutdown();

        try {
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            answer = answer.setScale(floatingPoint, RoundingMode.DOWN);
            return String.valueOf(answer);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(calculate(2));
        System.out.println(calculate(7));
        //System.out.println(calculate(100));
        //System.out.println(calculate(1000));
    }
}