package bd.ac.seu.aj.ParallelPi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class Sorter<T> {
    private int termParts;
    public void sort(List<T> itemList, Comparator<T> comparator) {
        for(int i = 0; i < itemList.size(); i++) {
            for(int j = 0; j < itemList.size() - i - 1; j++) {
                T t1 = itemList.get(j);
                T t2 = itemList.get(j + 1);
                if(comparator.compare(t1, t2) > 0) {
                    itemList.set(j, t2);
                    itemList.set(j + 1, t1);
                }
            }
        }
    }

    public void parallelSorting(List<T> itemList, Comparator<T> comparator) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        Future futures[] = new Future[cores];

        termParts = itemList.size() / cores;
        int remaining = itemList.size() % cores;

        for(int i = 0; i < cores; i++) {
            int start = (itemList.size() / cores) * i;
            int end = start + termParts;
            if(cores == (i - 1))
                termParts = termParts + remaining;
            futures[i] = executorService.submit(() -> {
                for(int a = start; a < end; a++) {
                    for(int b = 0; b < end - a - 1; b++) {
                        T t1 = itemList.get(b);
                        T t2 = itemList.get(b + 1);
                        if(comparator.compare(t1, t2) > 0) {
                            itemList.set(b, t2);
                            itemList.set(b + 1, t1);
                        }
                    }
                }
            });
            try {
                futures[i].get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        List<Future[]> sortedIntegerList = new ArrayList<>();
        for(Future f : futures)
            try {
                sortedIntegerList.add((Future[]) f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        System.out.println(sortedIntegerList);
    }

    public void sort() {
        int array[] = {3, 2, 10, 37, 15};

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int k = 0; k < array.length; k++) {
            System.out.printf("%d ", array[k]);
        }
    }
}
