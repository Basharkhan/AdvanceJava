package bd.ac.seu.aj.ParallelPi;

import java.math.BigDecimal;

//correct value of pi
//3.141592653589793238462643383279502884197
public class Main {
    public Main() {
//        TestClass testClass = new TestClass();
//        testClass.doSomething();
/*
        PiCalculator piCalculators = new PiCalculator();
        piCalculators.getParallelPIExecutor(80000000, 4);
        System.exit(0);
*/
/*
        String doubleVal = "1.745";
        String doubleVal1 = "0.745";
        BigDecimal bdTest = new BigDecimal(  doubleVal);
        BigDecimal bdTest1 = new BigDecimal(  doubleVal1 );
        bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
        bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("bdTest:"+bdTest); //1.75
        System.out.println("bdTest1:"+bdTest1);//0.75, no problem
        System.exit(0);
*/
//        System.out.println("Number of cores: " + Runtime.getRuntime().availableProcessors());
//        System.exit(0);
/*
        PiCalculator piCalculator = new PiCalculator();
        System.out.println("kmh         " + piCalculator.getPi(90));
        System.out.println("bk          " + piCalculator.getKhanPi(90));
        System.out.println("Big Decimal " + piCalculator.getPIbigDecimal(1,11));
*/
    }

    public static void main(String args[]) {
        new Main();
    }
}
