package L6.z4;



import L6.z4.Comparators.ComparatorInterface;
import L6.z4.Comparators.NaturalComparator;
import L6.z4.Comparators.ReverseComparator;
import L6.z4.Hformula.HfomulaInterface;
import L6.z4.Hformula.MyFormula;
import L6.z4.Hformula.SuggestedFormula;
import L6.z4.Sorting.ShellSort;
import L6.z4.Sorting.Sort;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Sort shellSort = new ShellSort();

        HfomulaInterface suggestedFormula = new SuggestedFormula();
        HfomulaInterface myFormula = new MyFormula();

        ComparatorInterface reverseComparator = new ReverseComparator();
        ComparatorInterface naturalComparator = new NaturalComparator();

        Utils utils = new Utils();
        ArrayList<Integer> almostSortedArray1 = utils.generateAlmostSortedList(100);
        ArrayList<Integer> almostSortedArray2 = (ArrayList<Integer>) almostSortedArray1.clone();


        ArrayList<Integer> randomArray1 = utils.generateRandomList(100);
        ArrayList<Integer> randomArray2 = (ArrayList<Integer>) randomArray1.clone();


        ArrayList<Integer> almostSortedReversedArray1 = utils.generateAlmostSortedList(100);
        ArrayList<Integer> almostSortedReversedArray2 = (ArrayList<Integer>) almostSortedReversedArray1.clone();

        //utils.printList(almostSortedArray);
        System.out.println("-----------Almost sorted array-----------");
        System.out.println("Suggested formula");
        shellSort.sortArray(almostSortedArray1, naturalComparator, suggestedFormula);
        //utils.printList(almostSortedArray);
        System.out.println("My formula");
        shellSort.sortArray(almostSortedArray2, naturalComparator, myFormula);
        //utils.printList(almostSortedArray2);
        System.out.println("-----------Random array-----------");
        System.out.println("Suggested formula");
        shellSort.sortArray(randomArray1, naturalComparator, suggestedFormula);
        //utils.printList(almostSortedArray);
        System.out.println("My formula");
        shellSort.sortArray(randomArray2, naturalComparator, myFormula);
        //utils.printList(almostSortedArray2);
        System.out.println("-----------Almost sorted reversed array-----------");
        System.out.println("Suggested formula");
        shellSort.sortArray(almostSortedReversedArray1, reverseComparator, suggestedFormula);
        //utils.printList(almostSortedArray);
        System.out.println("My formula");
        shellSort.sortArray(almostSortedReversedArray2, reverseComparator, myFormula);
        //utils.printList(almostSortedArray2);
    }
}
