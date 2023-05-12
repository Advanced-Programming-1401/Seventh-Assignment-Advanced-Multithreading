package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.

     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */
    public static BigDecimal sum = new BigDecimal(3);
    public static synchronized void addTouSum(BigDecimal value){
        sum = sum.add(value);
    }
    public class calculatepi implements Runnable {
        MathContext mc = new MathContext(1000);
        int n ;
        public calculatepi(  int n ){
            this.n = n;
        }
        @Override
        public void run() {
            BigDecimal sign = new BigDecimal(1);
            if(n%2 == 0){
                sign = new BigDecimal(-1);
            }
            int denum = (n*2)*((n*2)+1)*((n*2)+2);
            BigDecimal numerator = new BigDecimal(4);
            BigDecimal denominator = new BigDecimal(denum);
            denominator = denominator.multiply(sign,mc);
            BigDecimal result = numerator.divide(denominator,mc);
            addTouSum(result);
        }
    }

    public String calculate (int floatingPoint)
    {
        // TODO
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        for (int i = 1; i < floatingPoint*30 ; i++) {
            calculatepi task = new calculatepi(i);
            threadPool.execute(task);
        }

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = sum.setScale(floatingPoint, RoundingMode.FLOOR);
        return sum.setScale(floatingPoint).toPlainString();
    }

    public static void main(String[] args) {

    }
}
