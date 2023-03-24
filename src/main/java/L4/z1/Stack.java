package L4.z1;

public class Stack<T> implements StackInterface<T> {

    private static final int DEFAULT_CAPACITY = 10;
    T array[];
    int topIndex;

    @SuppressWarnings("unchecked")
    public Stack(int initialSize) {
        array=(T[])(new Object[initialSize]);
        topIndex=0;
    }
    public Stack (){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return topIndex==0;
    }

    @Override
    public boolean isFull() {
        return topIndex==array.length;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Empty Stack");
        return array[--topIndex];
    }

    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            throw new FullStackException("Full Stack");
        array[topIndex++] = elem;
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Empty Stack");
        return array[topIndex-1];
    }
}
class EmptyStackException extends Exception{
    public EmptyStackException(String message) {
        super(message);
    }
}
class FullStackException extends Exception{
    public FullStackException(String message) {
        super(message);
    }
}