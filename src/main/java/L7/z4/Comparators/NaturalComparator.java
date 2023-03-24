package L7.z4.Comparators;

import L7.z4.Student;

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
