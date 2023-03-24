package L4.z4;


public interface SelfExpandingStackInterface<T> {

    boolean isEmpty();
    T pop() throws EmptyStackException;
    void push(T elem);
    int size();
    T top() throws EmptyStackException;
}
