package L7.z3.Comparators;

import L7.z3.Student;

public class NaturalComparator<E> implements ComparatorInterace<E> {

    @Override
    public int compare(Student left, Student right) {

        if(left.getIndex() > right.getIndex()){
            return 1;
        } else if (left.getIndex() < right.getIndex()){
            return -1;
        } else {
            return 0;
        }
    }

}
