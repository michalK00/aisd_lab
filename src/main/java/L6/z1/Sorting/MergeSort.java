package L6.z1.Sorting;

import L6.z1.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class MergeSort<E> implements Sort<E>{

    private int comparisonsNumber = 0;
    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        ArrayList<E> list2 = new ArrayList<>();
        float start = System.nanoTime();

        list2 = mergeSort(list, comparator);

        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("Merge sort");
        System.out.println("Number of elements: "+ list.size());
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");
        System.out.println("Number of comparisons: " + comparisonsNumber);
        return list2;
    }
    private ArrayList<E> mergeSort(ArrayList<E> list, ComparatorInterface comparator){

        if(list.size()<2){
            return list;
        }
        int mid = list.size()/2;
        ArrayList<E> listLeft = new ArrayList<>();
        ArrayList<E> listRight = new ArrayList<>();

        for(int x = 0; x<mid; x++){
            listLeft.add(list.get(x));
        }
        for(int x = mid; x<list.size(); x++){
            listRight.add(list.get(x));
        }
        mergeSort(listLeft, comparator);
        mergeSort(listRight, comparator);

        merge(list, listLeft, listRight, comparator);
        return list;
    }
    private void merge(ArrayList<E> list, ArrayList<E> listL, ArrayList<E> listR, ComparatorInterface comparator){
        list.clear();
        while(!listL.isEmpty() && !listR.isEmpty()){
            if(comparator.compare(listL.get(0),listR.get(0)) >= 0){
                list.add(listR.get(0));
                listR.remove(0);
            } else{
                list.add(listL.get(0));
                listL.remove(0);
            }
            comparisonsNumber++;
        }
        while(!listL.isEmpty()){
            list.add(listL.get(0));
            listL.remove(0);
        }
        while(!listR.isEmpty()){
            list.add(listR.get(0));
            listR.remove(0);
        }
    }
}
