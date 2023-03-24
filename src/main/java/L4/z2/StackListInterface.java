package L4.z2;


public interface StackListInterface<E> {
    boolean isEmpty();
    E pop() throws EmptyStackException;
    void push(E elem);
    int size();
    E top() throws EmptyStackException;
}
