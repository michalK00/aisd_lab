package L5.z1.Sorting;


import L5.z1.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class BubbleSort<E> implements Sort<E>{

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        int swapsCounter = 0;
        float start = System.nanoTime();
        int lastSwap = list.size()-1;
        while(lastSwap>0){
            int end = lastSwap;
            lastSwap = 0;
            for(int left = 0; left<end;left++){
                if(comparator.compare(list.get(left), list.get(left+1))>0){
                    E temp = list.get(left);
                    while(left<end && comparator.compare(temp,list.get(left+1))>0){
                        list.set(left, list.get(left+1));
                        left++;
                        swapsCounter++;
                    }
                    lastSwap = left;
                    list.set(left, temp);
                }
            }
        }
        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("Bubble sort");
        System.out.println("Number of elements: "+ list.size());
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");
        System.out.println("Number of swaps: " + swapsCounter);
        return list;
    }





}
