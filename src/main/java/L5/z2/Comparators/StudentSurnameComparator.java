package L5.z2.Comparators;

import L5.z2.Student;

public class StudentSurnameComparator<E> implements ComparatorInterface<E>{

    @Override
    public int compare(E left, E right) {
        Student sLeft = (Student) left;
        Student sRight = (Student) right;
        return sLeft.getSurname().compareTo(sRight.getSurname());
    }
}
