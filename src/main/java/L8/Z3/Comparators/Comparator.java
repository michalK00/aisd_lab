package L8.Z3.Comparators;

public class Comparator<E> implements ComparatorInterface<E> {

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
