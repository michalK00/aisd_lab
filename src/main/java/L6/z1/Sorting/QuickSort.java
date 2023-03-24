package L6.z1.Sorting;

import L6.z1.Comparators.ComparatorInterface;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort<E> implements Sort<E> {

    Random random = new Random();
    private int swapsCounter = 0;

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {

        float start = System.nanoTime();

        quickSort(list, 0, list.size(), comparator);

        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("Quick sort");
        System.out.println("Number of elements: "+ list.size());
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");
        System.out.println("Number of swaps: " + swapsCounter);
        return list;
    }

    private void quickSort(ArrayList<E> list, int begin, int end, ComparatorInterface comparator){
        if(end - begin > 1){
            int partition = partitioning(list, begin, end, comparator);
            quickSort(list, begin, partition, comparator);
            quickSort(list, partition + 1, end, comparator);}
        }
    private int partitioning(ArrayList<E> list, int begin, int end, ComparatorInterface comparator){

        int pivot = begin + random.nextInt(end-begin);

        swap(list,begin,pivot);
        E value=list.get(begin);

        int indexBigger = begin +1, indexLower = end-1;

        do{
            while(indexBigger<=indexLower && comparator.compare(list.get(indexBigger),value)<=0)
                indexBigger++;
            while(comparator.compare(list.get(indexLower),value)>0)
                indexLower--;
            if(indexBigger<indexLower)
                swap(list,indexBigger,indexLower);
        }while(indexBigger<indexLower);

        swap(list,indexLower,begin);

        return indexLower;
    }
    private void swap(ArrayList<E> list, int left, int right){
        if(left != right){
            swapsCounter++;
            E temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }
}
