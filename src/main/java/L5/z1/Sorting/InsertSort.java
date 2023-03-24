package L5.z1.Sorting;

import L5.z1.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class InsertSort<E> implements Sort<E>{

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {

        int swapsCounter = 0;
        float start = System.nanoTime();
        int currentPostion = 1;
        while(currentPostion!=list.size()){
            int x = 0;
            while(x < list.size() && comparator.compare(list.get(currentPostion),list.get(x))>0){
                x++;
            }
            if (x != currentPostion) {
                swapsCounter++;
                list.add(x, list.get(currentPostion));
                list.remove(currentPostion+1);
            }
            currentPostion++;

        }
        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("Insert sort");
        System.out.println("Number of elements: "+ list.size());
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");
        System.out.println("Number of swaps: " + swapsCounter);
        return list;
    }

}
