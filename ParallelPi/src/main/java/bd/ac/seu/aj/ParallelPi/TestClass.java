package bd.ac.seu.aj.ParallelPi;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public void doSomething() {
        List<Integer> integerList = new ArrayList<>();
        int randomNumber = 0;

        for(int i = 0; i < 100; i++) {
            randomNumber = (int) (Math.random() * 100);
            integerList.add(randomNumber);
        }

        System.out.println(integerList);

    }
}
