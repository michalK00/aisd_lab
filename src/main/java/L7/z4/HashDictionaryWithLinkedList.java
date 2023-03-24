package L7.z4;


import L7.z4.Comparators.ComparatorInterace;
import L7.z4.LinkedList.TwoWayLinkedListWithSentinel;

import java.util.Iterator;

public class HashDictionaryWithLinkedList {

    private TwoWayLinkedListWithSentinel<Student> tab[];
    private ComparatorInterace<Student> comp;
    private int size;

    public HashDictionaryWithLinkedList(ComparatorInterace<Student> comp, int initialSize){
        this.comp = comp;
        tab = new TwoWayLinkedListWithSentinel[(int) (2*initialSize)];
        size = 0;
    }

    public int indexOf(Student s){
        int positionInTable = Math.abs(s.hashCode() % tab.length);
        if(tab[positionInTable] != null){
            int positionInList = tab[positionInTable].indexOf(s);
            if((positionInList != -1)) {
                System.out.println("Position in table: " + positionInTable + ", position in list: " + positionInList);
                return positionInList;
            }
        }
        System.out.println("Element does not exist in dictionary");
        return -1;
    }

    public void add(Student s){
        arrayOverfillFix();
        hashFunctionAdding(s, tab);
    }

    public void viewDictionary(){
        for (int x = 0; x < tab.length; x++) {
            if(tab[x] != null) {
                tab[x].printWholeList();
                System.out.println();
            } else {
                System.out.println("Empty index: " + x);
                System.out.println();
            }
        }
        System.out.println();
    }

    public boolean contains(Student s){
        if(indexOf(s) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public TwoWayLinkedListWithSentinel[] getTab() {
        return tab;
    }


    private void hashFunctionAdding(Student s, TwoWayLinkedListWithSentinel[] tab){
        int positionInTable = Math.abs(s.hashCode() % tab.length);
        if(tab[positionInTable] == null) {
            tab[positionInTable] = new TwoWayLinkedListWithSentinel();
        }
        tab[positionInTable].add(s);

        if((tab[positionInTable].size()) > size){
            size = tab[positionInTable].size();
        }
    }
    private void arrayOverfillFix(){
        if(size >= 0.8 * tab.length){
            size = 0;
            TwoWayLinkedListWithSentinel<Student>[] temp = new TwoWayLinkedListWithSentinel[2* tab.length];
            for (int x = 0; x < tab.length; x++) {
                if(tab[x] != null) {
                    Iterator<Student> iter = tab[x].iterator();
                    while(iter.hasNext()){
                        Student s = iter.next();
                        hashFunctionAdding(s, temp);
                    }
                }
            }
            tab = temp;
        }
    }


}
