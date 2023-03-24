package L6.z3.Comparators;


import java.util.ArrayList;

public class ComplexComparator<E> implements ComparatorInterface<E> {
    ArrayList<ComparatorInterface> listOfComparators = new ArrayList<>();
    ComparatorInterface gradeComp = new StudentGradeComparator();
    ComparatorInterface indexComp = new StudentIndexComparator();

    public ComplexComparator() {
        listOfComparators.add(gradeComp);
        listOfComparators.add(indexComp);
    }

    @Override
    public int compare(E left, E right) throws ClassCastException{
        int result = 0;
        for(Object obj: listOfComparators){
            ComparatorInterface<E> comp = (ComparatorInterface<E>) obj;
            result = comp.compare(left, right);
            if(result!=0) break;
        }
        return result;
    }
}
