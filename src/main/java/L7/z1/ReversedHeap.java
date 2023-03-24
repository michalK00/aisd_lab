package L7.z1;

import L7.z1.Comparators.ComparatorInterace;
import L7.z1.Comparators.ReverseComparator;
import L7.z1.CustomExeptions.EmptyQueueException;

import java.util.ArrayList;

public class ReversedHeap {

    private ArrayList<Klient> list = new ArrayList<>();
    private ComparatorInterace comparator = new ReverseComparator();


    public void enqueue(Klient k){
        list.add(k);
        swim(list.size()-1);
    }
    public Klient dequeue() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException("Queue is empty");
        }
        Klient result = list.get(0);
        if (list.size() > 1) {
            list.set(0, list.get(list.size() - 1));
            sink(0);
        }
        list.remove(list.size() - 1);

        return result;
    }

    private void swim(int index) {
        int parent;
        while(index != 0 && comparator.compare(list.get(index), list.get(parent= (index - 1) / 2)) > 0){
            swap(index, parent);
            index=parent;
        }
    }
    private void sink(int index) {
        boolean isDone=false;
        int child;
        while(!isDone && (child=2*index+ 1 ) < list.size()) {
            if (child < list.size()- 1 && comparator.compare(list.get(child), list.get(child+1)) < 0)
                ++child;
            if (comparator.compare(list.get(index), list.get(child)) < 0){
                swap(index, child);
                index=child;
            }
            else isDone=true;
        }
    }
    private void swap(int index1, int index2) {
        Klient temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public Klient first() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException("Queue is empty");
        return list.get(0);
    }
    public void printList(){
        for (Klient k: list) {
            System.out.println(k.getProcessingTime());
        }
    }

}
