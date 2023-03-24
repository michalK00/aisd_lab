package L6.z3.Sorting;

import L6.z3.Comparators.ComparatorInterface;
import L6.z3.Student;

import java.util.ArrayList;

public class BucketSort<E> implements Sort<E>{

    @Override
    public ArrayList sortArray(ArrayList<Student> list, ComparatorInterface comparator) {
        float start = System.nanoTime();
        ArrayList<Student> result = new ArrayList<>();
        ArrayList<Student> two = new ArrayList<>(), three = new ArrayList<>(),
                threeAndHalf = new ArrayList<>(), four = new ArrayList<>(),
                fourAndHalf = new ArrayList<>(), five = new ArrayList<>(), fiveAndHalf = new ArrayList<>();
        for(int x = 0; x<list.size(); x++){
            switch ((int) (list.get(x).getGrade()*2)){
                case 4:
                    two.add(list.get(x));
                    break;
                case 6:
                    three.add(list.get(x));
                    break;
                case 7:
                    threeAndHalf.add(list.get(x));
                    break;
                case 8:
                    four.add(list.get(x));
                    break;
                case 9:
                    fourAndHalf.add(list.get(x));
                    break;
                case 10:
                    five.add(list.get(x));
                    break;
                case 11:
                    fiveAndHalf.add(list.get(x));
                    break;
            }

        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sortArray(two, comparator);
        bubbleSort.sortArray(three, comparator);
        bubbleSort.sortArray(threeAndHalf, comparator);
        bubbleSort.sortArray(four, comparator);
        bubbleSort.sortArray(fourAndHalf, comparator);
        bubbleSort.sortArray(five, comparator);
        bubbleSort.sortArray(fiveAndHalf, comparator);
        result.addAll(two);
        result.addAll(three);
        result.addAll(threeAndHalf);
        result.addAll(four);
        result.addAll(fourAndHalf);
        result.addAll(five);
        result.addAll(fiveAndHalf);
        float finish = System.nanoTime();
        float timeElapsed = finish - start;
        System.out.println("----------Bucket sort----------");
        System.out.println("Total number of swaps: " + bubbleSort.getNumberOfSorts());
        System.out.println("Time elapsed: " + timeElapsed/1000000000 +" s");

        return result;
    }

}
