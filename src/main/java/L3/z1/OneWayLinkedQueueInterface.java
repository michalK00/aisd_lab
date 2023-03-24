package L3.z1;

import java.util.Iterator;

public interface OneWayLinkedQueueInterface<E> {


    public boolean isEmpty();

    public void clear();

    public void enqueue(E elem);

    public E dequeue() throws Exception;

    public int size();

//    @Override
//    Iterator<E> iterator();

}
