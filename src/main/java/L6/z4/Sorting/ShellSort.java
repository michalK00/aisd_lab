package L6.z4.Sorting;

import L6.z4.Comparators.ComparatorInterface;
import L6.z4.Hformula.HfomulaInterface;

import java.util.ArrayList;
import java.util.Stack;

public class ShellSort<E> implements Sort<E>{

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator, HfomulaInterface hFormula) {
        InsertSort<E> additionalSorter = new InsertSort<>();
        Stack<Integer> hStack = hFormula.createH(list.size());
        ArrayList<E> temp = new ArrayList<>();

        int h;
        int totalCompCounter = 0;
        int totalMoveCounter = 0;


        while (!hStack.empty()) {
            h = hStack.pop();
            for (int j = 0; j < h; j++) {
                for (int k = j; k < list.size(); k += h) {
                    temp.add(list.get(k));
                }
                additionalSorter.sortArray(temp,comparator, null);

                int tempIdx = 0;
                for (int k = j; k < list.size(); k += h) {
                    list.set(k, temp.get(tempIdx++));
                }
                temp.clear();
            }
        }
        System.out.println("Number of comparisons: " + additionalSorter.comparisonCounter);
        System.out.println("Number of swaps: " + additionalSorter.swapsCounter);

        return list;
    }

}
