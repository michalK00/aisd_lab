package L1.z3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements CustomIterator<T> {
    private T array[];
    private int position =0;

    public ArrayIterator(T array[]) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return position < array.length;
    }

    @Override
    public T  next() {
        if(hasNext())
            return array[position++];
        else
            throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void first() {
        position=0;
    }

    @Override
    public void last() {
        position=array.length-1;
    }

    @Override
    public T previous() {
        if(position>=1){
            return array[position--];
        }
        else
            throw new NoSuchElementException();
    }

    @Override
    public T current() {
        return array[position];
    }
}
