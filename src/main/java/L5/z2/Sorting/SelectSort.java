package L5.z2.Sorting;


import L5.z2.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class SelectSort<E> implements Sort<E> {

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        int currentPosition = 0;
        int lowestPosition = 0;

        while(currentPosition< list.size()){
            for(int x = currentPosition; x< list.size(); x++){
                if(comparator.compare(list.get(lowestPosition), list.get(x))==1){
                    swap(list, lowestPosition, x);
                }
            }
            currentPosition++;
            lowestPosition = currentPosition;
        }
        return list;
    }
    private void swap(ArrayList<E> list, int left, int right) {
        E temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

}
