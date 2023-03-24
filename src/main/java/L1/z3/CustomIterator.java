package L1.z3;

import java.util.NoSuchElementException;

public interface CustomIterator<T> {

    public boolean hasNext();
    public T next();
    public void remove();
    public void first();
    public void last();
    public T previous();
    public T current();
}
