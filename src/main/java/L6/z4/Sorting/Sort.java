package L6.z4.Sorting;


import L6.z4.Comparators.ComparatorInterface;
import L6.z4.Hformula.HfomulaInterface;

import java.util.ArrayList;

public interface Sort <E>{

    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator, HfomulaInterface hfomula);

}
