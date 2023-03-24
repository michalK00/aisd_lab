package L1.z3;

public final class FilterIterator<T> implements CustomIterator<T> {

    private CustomIterator<T> iterator;
    private Predicate<T> predicate;
    private T nextElement=null;
    private boolean hasNext = true;

    public FilterIterator(CustomIterator<T> iterator, Predicate<T> predicate){
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

    @Override
    public void first() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T current() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void last() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T previous() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
