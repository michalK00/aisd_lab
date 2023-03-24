package L4.z3;


public interface DrowningStackInterface<T> {
    boolean isEmpty();
    boolean isFull();
    T pop() throws EmptyStackException;
    void push(T elem);
    int size();
    T top() throws EmptyStackException;
}
