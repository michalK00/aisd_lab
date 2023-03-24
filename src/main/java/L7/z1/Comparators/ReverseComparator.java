package L7.z1.Comparators;


import L7.z1.Klient;

public class ReverseComparator<E> implements ComparatorInterace<E>{

    @Override
    public int compare(Klient left, Klient right) {

        if(left.getProcessingTime() > right.getProcessingTime()){
            return -1;
        } else if (left.getProcessingTime() < right.getProcessingTime()){
            return 1;
        } else {
            return 0;
        }
    }

}
