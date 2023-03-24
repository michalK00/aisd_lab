package L5.z2.Sorting;

import L5.z2.Comparators.ComparatorInterface;

import java.util.ArrayList;

public class InsertSort<E> implements Sort<E> {

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        int currentPostion = 1;
        while(currentPostion!=list.size()){
            int x = 0;
            while(x < list.size() && comparator.compare(list.get(currentPostion),list.get(x))>0){
                x++;
            }
            if (x != currentPostion) {
                list.add(x, list.get(currentPostion));
                list.remove(currentPostion+1);
            }
            currentPostion++;

        }
        return list;
    }

}
