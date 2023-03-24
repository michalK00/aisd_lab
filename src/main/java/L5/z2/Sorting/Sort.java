package L5.z2.Sorting;

import L5.z2.Comparators.ComparatorInterface;

import java.util.ArrayList;

public interface Sort <E>{

    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator);

}
