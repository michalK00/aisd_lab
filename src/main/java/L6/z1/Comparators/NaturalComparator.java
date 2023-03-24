package L6.z1.Comparators;

public class NaturalComparator<E> implements ComparatorInterface<E> {

    public int compare(E left, E right){
        if((Integer) left > (Integer) right){
            return 1;
        } else if ((Integer) left < (Integer) right){
            return -1;
        } else {
            return 0;
        }

    }
}
