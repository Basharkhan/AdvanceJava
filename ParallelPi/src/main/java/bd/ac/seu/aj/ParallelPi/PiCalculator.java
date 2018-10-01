package bd.ac.seu.aj.ParallelPi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

public class PiCalculator {
    public static final BigDecimal FOUR = new BigDecimal(4);
    private BigDecimal result = BigDecimal.ZERO;
    private long termParts;

    private synchronized void addResult(BigDecimal otherResult) {
        result = result.add(otherResult);
    }

    public double getPi(long terms) {
        double sum = 0;
        for(long i = 1; i <= terms; i++) {
            long denominator = 2 * i - 1;
            if(i % 2 == 0)
                sum -= 1.0 / denominator;
            else sum += 1.0 / denominator;
        }
        return sum * 4;
    }

/*
    public BigDecimal getPIbigDecimal(long terms) {
        BigDecimal sum = BigDecimal.ZERO;

        for(long i = 1; i <= terms; i++) {
            long denominator = 2 * i - 1;
            if(i % 2 == 0)
                sum = sum.subtract(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
            else
                sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
        }
        return sum.multiply(new BigDecimal(4));
    }
*/

public BigDecimal getPIbigDecimal(long start, long terms) {
    BigDecimal sum = BigDecimal.ZERO;

    for(long i = start; i <= start + terms; i++) {
        long denominator = 2 * i - 1;
        if(i % 2 == 0)
            sum = sum.subtract(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
        else
            sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.HALF_UP));
    }
    return sum.multiply(new BigDecimal(4));
}

    public double getKhanPi(int terms) {
        double pi, sum1 = 0, sum2 = 0;
        for(int x = 3; x <= terms; x = x + 2) {
            if((x / 2) % 2 == 0)
                sum1 += 1.0 / x;
            else
                sum2 -= 1.0 / x;
        }
        pi = 4 * (1 + (sum1 + sum2));
        return pi;
    }

    public BigDecimal getPIExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(Integer i : array) {
            executorService.submit(() -> {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        System.out.println("Done with thread submission");
        try {
            executorService.awaitTermination(5000l, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with all the threads: " + executorService.isTerminated());
        return result;
    }

    //Lambda
    public BigDecimal getParallelPIExecutor(long terms, int cores) {
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        result = BigDecimal.ZERO;
        termParts = terms / cores;
        long remaining = (terms % cores);

        for(int i = 0; i < cores; i++) {
            long start = 1 + (terms / cores) * i;
            if(i == cores - 1)
                termParts = termParts + remaining;
            executorService.submit(() -> {
                BigDecimal result = getPIbigDecimal(start, termParts);
                addResult(result);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with all the threads: " + executorService.isTerminated());
//        System.out.println(result);
        return result;
    }

    // Lambda and Callable
    public BigDecimal getParallelPIExecutorCallable(long terms, int cores) {
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        Future<BigDecimal> futures[] = new Future[cores];

        termParts = terms / cores;
        long remaining = (terms % cores);

        for(int i = 0; i < cores; i++) {
            long start = 1 + (terms / cores) * i;
            if(i == cores - 1)
                termParts = termParts + remaining;
            futures[i] = executorService.submit(() -> getPIbigDecimal(start, termParts));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with all the threads: " + executorService.isTerminated());

        BigDecimal futurePiValue = BigDecimal.ZERO;
        for(Future<BigDecimal> f : futures)
            try {
                futurePiValue = futurePiValue.add(f.get());
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } catch (ExecutionException ee) {
                ee.printStackTrace();
            }
        return futurePiValue;
    }

    //Parallel PI calculation
    public BigDecimal getParallelPI(long terms, int cores) {
        result = BigDecimal.ZERO;

        Thread threads[] = new Thread[cores];

        for(int  i = 0; i < cores; i++) {
            long start = 1 + (terms / cores) * i;
            long remaining = (terms % cores);
            termParts = (terms / cores);

            if(i == cores - 1)
                termParts = termParts + remaining;

            threads[i] = new Thread(() -> {
                BigDecimal result = getPIbigDecimal(start, termParts);
                addResult(result);
            }
            );
            threads[i].start();
        }


        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ie) {
                System.err.println(ie.toString());
            }
        }

        return result;
/*

        thread[i].start();

        Thread thread2 = new Thread(() -> {
            BigDecimal result2 = getPIbigDecimal(terms / 3 + 1 , terms / 3);
            addResult(result2);
        }
        );
        thread2.start();

        Thread thread3 = new Thread(() -> {
            BigDecimal result3 = getPIbigDecimal(terms / 3 + terms / 3, terms / 3);
            addResult(result3);
        });
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return result;
*/
    }

}
