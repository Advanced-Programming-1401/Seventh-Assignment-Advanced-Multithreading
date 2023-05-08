package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    public static BigDecimal sum = new BigDecimal(0);
    public static Lock lock = new ReentrantLock();

    public static synchronized void increaseSum(BigDecimal amount, MathContext mc){
        sum = sum.add(amount, mc);
    }
    public static class Task implements Runnable{

        int n;
        MathContext mc;
        Lock taskLock;
        public Task(int n, MathContext mc, Lock lock2) {
            this.n = n;
            this.mc = mc;
            this.taskLock = lock2;
        }


        @Override
        public void run() {
//            BigDecimal r;
//            if(n%2 ==1){
//                BigDecimal num = new BigDecimal(4);
//                BigDecimal den = new BigDecimal(2);
//                den = den.multiply(BigDecimal.valueOf(n), mc);
//                den = den.add(BigDecimal.valueOf(-1));
//                r = num.divide(den, mc);
//            }
//            else{
//                BigDecimal num = new BigDecimal(-4);
//                BigDecimal den = new BigDecimal(2);
//                den = den.multiply(BigDecimal.valueOf(n), mc);
//                den = den.add(BigDecimal.valueOf(-1));
//                r = num.divide(den, mc);
//            }
//            increaseSum(r,mc);

            BigDecimal num = factorial(n).pow(2,mc);
            BigDecimal pow2 = new BigDecimal(2);

            pow2 = pow2.pow(n+1);
            num = num.multiply(pow2, mc);
            BigDecimal dem = factorial(2*n +1);

            num = num.divide(dem,mc);

            increaseSum(num,mc);
        }

        public BigDecimal factorial(int num){
            BigDecimal temp = BigDecimal.ONE;
            for(int i = 2; i <= num; i++){
                temp = temp.multiply(new BigDecimal(i,mc));
            }
            return temp;
        }
    }

    public String calculate(int floatingPoint)
    {
        floatingPoint++;

        MathContext mathContext = new MathContext(1005);

        ExecutorService threadPool = Executors.newFixedThreadPool(16);

        int n = 2000000; // number of terms
        for(int i = 0; i <= n; i++){
            Task task = new Task(i,mathContext, lock);
            threadPool.execute(task);
        }

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(20000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = sum.setScale(floatingPoint-1, RoundingMode.DOWN);
        return sum.toString();
    }

    public static void main(String[] args) {
        PiCalculator piCalculator = new PiCalculator();
        String a = piCalculator.calculate(1000);

        System.out.println(a);
        System.out.println("3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094330572703657595919530921861173819326117931051185480744623799627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051320005681271452635608277857713427577896091736371787214684409012249534301465495853710507922796892589235420199561121290219608640344181598136297747713099605187072113499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473035982534904287554687311595628638823537875937519577818577805321712268066130019278766111959092164201989");
        System.exit(0);
    }
}
