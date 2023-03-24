package L6.z1.Sorting;


import L6.z1.Comparators.ComparatorInterface;

import java.util.ArrayList;

public interface Sort <E>{

    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator);

}
