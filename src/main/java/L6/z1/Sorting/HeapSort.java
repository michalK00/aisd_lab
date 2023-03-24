package L6.z1.Sorting;

import L6.z1.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class HeapSort<E> implements Sort<E> {

    private int numberOfHeapAdjustments = 0;
    private int numberOfComparisons = 0;
    private int numberOfSwaps = 0;

    ComparatorInterface comp;
    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        float start = System.nanoTime();
        comp = comparator;

        heapsort(list, list.size());

        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("Heap sort");
        System.out.println("Number of elements: "+ list.size());
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");
        System.out.println("Number of swaps: " + numberOfSwaps);
        System.out.println("Number of comparisons: " + numberOfComparisons);
        System.out.println("Number of heap adjustments: " + numberOfHeapAdjustments);

        return list;
    }

    private void heapsort(ArrayList<E> heap, int n) {
        heapAdjustment(heap, n);
        for(int i=n-1;i>0;i--){
            swap(heap,i,0);
            sink(heap,0,i);
        }
    }

    void heapAdjustment(ArrayList<E> heap,int n)
    {
        for(int i=(n-1)/2;i>=0;i--){
            numberOfHeapAdjustments++;
            sink(heap, i, n);
        }

    }

    public void sink(ArrayList<E> heap,int idx, int n){

        int idxOfBigger=2*idx+1;

        if(idxOfBigger<n){

            if(idxOfBigger+1<n &&
                    comp.compare(heap.get(idxOfBigger), heap.get(idxOfBigger+1))<0)

                idxOfBigger++;
            if(comp.compare(heap.get(idx), heap.get(idxOfBigger))<0){
                swap(heap,idx,idxOfBigger);
                sink(heap,idxOfBigger,n);
            }
            numberOfComparisons++;
            numberOfComparisons++;
        }
    }

    private void swap(ArrayList<E> list, int left, int right){
        if(left != right){
            E temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            numberOfSwaps++;
        }
    }
}
