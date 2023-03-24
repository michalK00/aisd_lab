package L1.z1;

import java.util.Iterator;

public final class FilterIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private Predicate<T> predicate;
    private T nextElement=null;
    private boolean hasNext = true;

    public FilterIterator(Iterator<T> iterator, Predicate<T> predicate){
        super();
        this.iterator = iterator;
        this.predicate = predicate;
        findNextValid();
    }

    private void findNextValid(){
        while(iterator.hasNext()){
            nextElement = iterator.next();
            if(predicate.accept(nextElement)){
                return;
            }
        }
        hasNext = false;
        nextElement = null;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public T next() {
        T nextValue = nextElement;
        findNextValid();
        return nextValue;
    }
}
