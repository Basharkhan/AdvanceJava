import bd.ac.seu.aj.ParallelPi.PiCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PiTester {

/*
    @Test
    public void testPi() {
        //correct value of pi
        PiCalculator piCalculator = new PiCalculator();
        String correctValue = "3.141592653589793238462643383279502884197";
        String calculatedValue = String.format("%.39f\n",piCalculator.getPi(8000000l));
        System.out.printf("Correct Value    : %s\n", correctValue);
        System.out.printf("Calculated Value : %s\n", calculatedValue);
    }
*/

/*
    @Test
    public void testPIbigDecimal() {
        //correct value of pi
        PiCalculator piCalculator = new PiCalculator();
        String correctValue = "3.141592653589793238462643383279502884197";
        String calculatedValue = piCalculator.getPIbigDecimal(1,8000000l).toPlainString().substring(0, 41);
        System.out.printf("Correct Value    : [%s]\n", correctValue);
        System.out.printf("Calculated Value : [%s]\n", calculatedValue);
    }
*/
    @Test
    public void testMultiThread() {
        int cores = Runtime.getRuntime().availableProcessors();
        PiCalculator piCalculator = new PiCalculator();
        BigDecimal result = piCalculator.getParallelPI(1000, cores);
        BigDecimal lambda = piCalculator.getParallelPIExecutor(1000, cores);
        String calculatedValue = result.toPlainString().substring(0, 41);
        String correctValue = "3.141592653589793238462643383279502884197";
        System.out.printf("Correct Value    : [%s]\n", correctValue);
        System.out.printf("Calculated Value : [%s]\n", calculatedValue);
        System.out.printf("Lambda           : [%.41s]\n", lambda);
    }

    @Test
    public void getPIExecutor() {
        PiCalculator piCalculator = new PiCalculator();
        BigDecimal calculatedValue = piCalculator.getParallelPIExecutor(80000000, 4);
        String correctValue = "3.141592653589793238462643383279502884197";
        System.out.printf("Correct Value    : [%s]\n", correctValue);
        System.out.printf("Calculated Value : [%.41s]\n", calculatedValue);
    }

    @Test
    public void testGetParallelPIExecutorCallable() {
        PiCalculator piCalculator = new PiCalculator();
        BigDecimal calculatedValue = piCalculator.getParallelPIExecutorCallable(80000000, 4);
        String correctValue = "3.141592653589793238462643383279502884197";
        System.out.printf("Correct Value    : [%s]\n", correctValue);
        System.out.printf("Calculated Value : [%.41s]\n", calculatedValue);
    }

}
