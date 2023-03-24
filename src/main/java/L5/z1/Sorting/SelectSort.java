package L5.z1.Sorting;



import L5.z1.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class SelectSort<E> implements Sort<E>{

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        int swapsCounter = 0;
        float start = System.nanoTime();

        int currentPosition = 0;
        int lowestPosition = 0;

        while(currentPosition< list.size()){
            for(int x = currentPosition; x< list.size(); x++){
                if(comparator.compare(list.get(lowestPosition), list.get(x))==1){
                    swap(list, lowestPosition, x);
                    swapsCounter++;
                }
            }
            currentPosition++;
            lowestPosition = currentPosition;
        }
        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("Select sort");
        System.out.println("Number of elements: "+ list.size());
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");
        System.out.println("Number of swaps: " + swapsCounter);
        return list;
    }
    private void swap(ArrayList<E> list, int left, int right) {
        E temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

}
