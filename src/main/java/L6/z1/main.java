package L6.z1;

import L6.z1.Comparators.*;
import L6.z1.Sorting.*;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Sort mergeSort = new MergeSort();
        Sort quickSort = new QuickSort();
        Sort heapSort = new HeapSort();
        ComparatorInterface reverseComparator = new ReverseComparator();
        ComparatorInterface naturalComparator = new NaturalComparator();

        Utils utils = new Utils();
        ArrayList<Integer> almostSortedArray1 = utils.generateAlmostSortedList(30000);
        ArrayList<Integer> almostSortedArray2 = (ArrayList<Integer>) almostSortedArray1.clone();
        ArrayList<Integer> almostSortedArray3 = (ArrayList<Integer>) almostSortedArray1.clone();

        ArrayList<Integer> randomArray1 = utils.generateRandomList(30000);
        ArrayList<Integer> randomArray2 = (ArrayList<Integer>) randomArray1.clone();
        ArrayList<Integer> randomArray3 = (ArrayList<Integer>) randomArray1.clone();

        ArrayList<Integer> almostSortedReversedArray1 = utils.generateAlmostSortedList(30000);
        ArrayList<Integer> almostSortedReversedArray2 = (ArrayList<Integer>) almostSortedReversedArray1.clone();
        ArrayList<Integer> almostSortedReversedArray3 = (ArrayList<Integer>) almostSortedReversedArray1.clone();
        //utils.printList(almostSortedArray);
        System.out.println("-----------Almost sorted array-----------");
        mergeSort.sortArray(almostSortedArray1, naturalComparator);
        //utils.printList(almostSortedArray);
        quickSort.sortArray(almostSortedArray2, naturalComparator);
        //utils.printList(almostSortedArray2);
        heapSort.sortArray(almostSortedArray2, naturalComparator);
        //utils.printList(almostSortedArray3);
        System.out.println("-----------Random array-----------");
        mergeSort.sortArray(randomArray1, naturalComparator);
        //utils.printList(almostSortedArray);
        quickSort.sortArray(randomArray2, naturalComparator);
        //utils.printList(almostSortedArray2);
        heapSort.sortArray(randomArray3, naturalComparator);
        //utils.printList(almostSortedArray3);
        System.out.println("-----------Almost sorted reversed array-----------");
        mergeSort.sortArray(almostSortedReversedArray1, reverseComparator);
        //utils.printList(almostSortedArray);
        quickSort.sortArray(almostSortedReversedArray2, reverseComparator);
        //utils.printList(almostSortedArray2);
        heapSort.sortArray(almostSortedReversedArray3, reverseComparator);
        //utils.printList(almostSortedArray3);


    }
}
