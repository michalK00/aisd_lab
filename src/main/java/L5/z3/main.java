package L5.z3;


import L5.z3.Comparators.ComparatorInterface;
import L5.z3.Comparators.NaturalComparator;
import L5.z3.Sorting.ShakerSort;
import L5.z3.Sorting.Sort;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Sort shakerSort = new ShakerSort();
        ComparatorInterface comparator = new NaturalComparator();

        Utils utils = new Utils();
        ArrayList<Integer> list = utils.generateRandomList(10);
        System.out.println("Stan początkowy listy:");
        utils.printList(list);
        shakerSort.sortArray(list, comparator);
        System.out.println("Stan końcowy listy:");
        utils.printList(list);
    }
}
