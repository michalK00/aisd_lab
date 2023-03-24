package L6.z3.Comparators;


import L6.z3.Student;

public class StudentGradeComparator<E> implements ComparatorInterface<E> {

    @Override
    public int compare(E left, E right) {
        Student sLeft = (Student) left;
        Student sRight = (Student) right;
        if(sLeft.getGrade()<sRight.getGrade()){
            return 1;
        }else if(sLeft.getGrade()>sRight.getGrade()){
            return -1;
        } else
            return 0;
    }
}
