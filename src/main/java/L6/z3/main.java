package L6.z3;

import L6.z3.Comparators.ComparatorInterface;
import L6.z3.Comparators.ComplexComparator;
import L6.z3.Sorting.BubbleSort;
import L6.z3.Sorting.BucketSort;
import L6.z3.Sorting.Sort;

import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList<>();
        Random random = new Random();
        int n = 10000;
        double[] grades = {2.0, 3, 3.5, 4, 4.5, 5, 5.5};

        for(int x = 0; x<n; x++){
            boolean duplicated = true;
            do{
                int grade = random.nextInt(grades.length);
                int index = random.nextInt(9999);
                if(!list1.contains(new Student(260000+index, 0.0))){
                    list1.add(new Student(260000 + index, grades[grade]));
                    duplicated = false;
                }
            }while(duplicated);
        }
        //System.out.println("INPUT:");
        //utils.printList(list1);

        ArrayList list2 = (ArrayList) list1.clone();

        ComparatorInterface complexComp = new ComplexComparator();

        System.out.println("Sortowanie bąbelkowe przy użyciu komparatora złożonego:");
        Sort bubbleSort = new BubbleSort();
        bubbleSort.sortArray(list1, complexComp);
        //utils.printList(list1);
        System.out.println();
        System.out.println();
        System.out.println("Sortowanie kubełkowe przy użyciu komparatora złożonego:");
        Sort bucketSort = new BucketSort();
        bucketSort.sortArray(list2, complexComp);
        //utils.printList(list2);

    }
}
