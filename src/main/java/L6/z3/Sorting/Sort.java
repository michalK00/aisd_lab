package L6.z3.Sorting;

import L6.z3.Comparators.ComparatorInterface;
import L6.z3.Student;

import java.util.ArrayList;

public interface Sort <E>{


    public ArrayList<Student> sortArray(ArrayList<Student> list, ComparatorInterface comparator);

}
