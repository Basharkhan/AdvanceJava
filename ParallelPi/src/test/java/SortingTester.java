import bd.ac.seu.aj.ParallelPi.Sorter;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SortingTester {
    @Test
    public void testSorter() {
//        List<Integer> integerList = new ArrayList<>(Arrays.asList(4, 2, 20, 10, 5));
//        List<Integer> sortedList = new ArrayList<>(Arrays.asList(2, 4, 5, 10, 20));
        List<Integer> integerList = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();
        int randomNumber;

        for(int i = 0; i < 10000; i++) {
            randomNumber = (int) (Math.random() * 10000);
            integerList.add(randomNumber);
            sortedList.add(randomNumber);
        }

        Collections.sort(sortedList);
        System.out.println("Done with java sort");

        Sorter<Integer> sorter = new Sorter();
        sorter.sort(integerList, (i1, i2) -> i1 - i2);
        System.out.println("Done with bubble sort");
        System.out.println("Bubble sort" + integerList);
        System.out.println("Java sorting" + sortedList);
    }

    @Test
    public void testParallelSorting() {
        List<Integer> integerList = new ArrayList<>();
        int randomNumber;
        for(int i = 0; i < 40; i++) {
            randomNumber = (int) (Math.random() * 40);
            integerList.add(randomNumber);
        }
        System.out.println("Before sorting" + integerList);
        Sorter<Integer> sorter = new Sorter();
        sorter.parallelSorting(integerList, (a1, a2) -> a1 - a2);
        System.out.println("After sorting " + integerList);
    }
}
