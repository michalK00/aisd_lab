package L5.z2.Comparators;

import L5.z2.Student;

public class StudentIndexComparator<E> implements ComparatorInterface<E>{
    @Override
    public int compare(E left, E right) {
        Student sLeft = (Student) left;
        Student sRight = (Student) right;
        if(sLeft.getIndex()<sRight.getIndex()){
            return -1;
        }else if(sLeft.getIndex()>sRight.getIndex()){
            return 1;
        } else
            return 0;
    }
}
