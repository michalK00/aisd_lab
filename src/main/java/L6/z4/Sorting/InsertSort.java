package L6.z4.Sorting;

import L6.z4.Comparators.ComparatorInterface;
import L6.z4.Hformula.HfomulaInterface;

import java.util.ArrayList;

public class InsertSort<E> implements Sort<E> {
    int comparisonCounter = 0;
    int swapsCounter = 0;
    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator, HfomulaInterface hfomula) {



        int currentPostion = 1;
        while(currentPostion!=list.size()){
            int x = 0;
            while(x < list.size() && comparator.compare(list.get(currentPostion),list.get(x))>0){
                x++;
                comparisonCounter++;
            }
            if (x != currentPostion) {
                swapsCounter++;
                list.add(x, list.get(currentPostion));
                list.remove(currentPostion+1);
            }
            currentPostion++;

        }
        return list;
    }

}
