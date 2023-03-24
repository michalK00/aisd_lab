package L7.z4.LinkedList;

import java.util.Iterator;


public interface LinkedListInterface<E> {


    public boolean add(E e);
    public E set(int index, E element);

    public void add(int index, E element);

    public E remove(int index);

    public int indexOf(Object o);

    public void clear();

    public Iterator<E> iterator();

    public boolean equals(Object o);

    public E get(int index);
}
