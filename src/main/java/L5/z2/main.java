package L5.z2;

import L5.z2.Comparators.*;
import L5.z2.Sorting.*;


import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList<>();
        Utils utils = new Utils();

        Student s1 = new Student("Adam", "Kowalski", 400, 5);
        list1.add(s1);
        Student s2 = new Student("Bartosz", "Kowalski", 401, 4);
        list1.add(s2);
        Student s3 = new Student("Cyprian", "Kowalski", 403, 5);
        list1.add(s3);
        Student s4 = new Student("Damian", "Kowalski", 399, 5);
        list1.add(s4);
        Student s5 = new Student("Edward", "Kowalski", 300, 6);
        list1.add(s5);
        Student s6 = new Student("Fabian", "Adamowski", 300, 6);
        list1.add(s6);
        System.out.println("INPUT:");
        utils.printList(list1);

        ArrayList list2 = (ArrayList) list1.clone();
        ArrayList list3 = (ArrayList) list1.clone();

        ComparatorInterface gradeComp = new StudentGradeComparator();
        ComparatorInterface indexComp = new StudentIndexComparator();
        ComparatorInterface complexComp = new ComplexComparator();

        System.out.println("Sortowanie przy użyciu komparatora złożonego: (kolejność nazwisko, ocena (malejąco), index (rosnąco))");
        Sort bubbleSort = new BubbleSort();
        bubbleSort.sortArray(list1, complexComp);
        utils.printList(list1);
        System.out.println("Sortowanie przy użyciu komparatora ocen: (malejąco)");
        bubbleSort.sortArray(list2, gradeComp);
        utils.printList(list2);
        System.out.println("Sortowanie przy użyciu komparatora indeksów: (rosnąco)");
        bubbleSort.sortArray(list3, indexComp);
        utils.printList(list3);
    }
}
