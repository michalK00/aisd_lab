package L5.z2.Sorting;

import L5.z2.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class BubbleSort<E> implements Sort<E> {

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        boolean swapped = false;
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
                    }
                    lastSwap = left;
                    list.set(left, temp);
                }
            }
        }
        return list;
    }





}
