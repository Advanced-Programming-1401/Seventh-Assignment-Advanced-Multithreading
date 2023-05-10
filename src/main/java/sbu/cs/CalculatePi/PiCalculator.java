package sbu.cs.CalculatePi;

import java.math.BigDecimal;

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

    public static double calculate(int floatingPoint) {
        double sum = 0;
        for (int i = 1; i < 2147483647; i++) {
            if (i % 2 == 0)
                sum -= (double) 1 / (2 * i - 1);
            else
                sum += (double) 1 / (2 * i - 1);
        }
        return 4*(sum);
    }

    public static void main (String[]args) {
        System.out.println(calculate(4));
        // Use the main function to test the code yourself
    }
}
