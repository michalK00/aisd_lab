package L2.z4;
import java.util.Iterator;

public interface OneWayCycleListInterface<E> extends Iterable<E> {

    public boolean isEmpty();

    public void clear();

    public int size();

    public int indexOf(E e);

    public boolean add(E e);

    public E get(int index);

    public E set(int index, E element);

    public E remove(int index);

    public boolean remove(E value);

//    public boolean equals(E o);
    @Override
    Iterator<E> iterator();
}
