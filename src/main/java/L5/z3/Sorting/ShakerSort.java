package L5.z3.Sorting;

import L5.z3.Comparators.ComparatorInterface;
import L5.z3.Utils;

import java.util.ArrayList;

public class ShakerSort<E> implements Sort<E>{

    @Override
    public ArrayList<E> sortArray(ArrayList<E> list, ComparatorInterface comparator) {
        Utils utils = new Utils();
        boolean swapped = true;
        int end = list.size()-1;
        int start = 0;
        System.out.println("Rozpoczęcie sortowania");
        while(swapped){

            swapped = false;

            for(int x = start; x<end;x++){
                if(comparator.compare(list.get(x), list.get(x+1))>0){
                    E temp = list.get(x);
                    list.set(x, list.get(x+1));
                    list.set(x+1, temp);
                    swapped = true;
                }
            }
            System.out.println("Po kroku 1:");
            utils.printList((ArrayList<Integer>) list);
            end--;
            for(int x = end; x>start;x--){
                if(comparator.compare(list.get(x), list.get(x-1))<0){
                    E temp = list.get(x);
                    list.set(x, list.get(x-1));
                    list.set(x-1, temp);
                    swapped = true;
                }
            }
            System.out.println("Po kroku 2:");
            utils.printList((ArrayList<Integer>) list);
            start++;
        }
        System.out.println("Zakończenie sortowania");
        return list;
    }

}
