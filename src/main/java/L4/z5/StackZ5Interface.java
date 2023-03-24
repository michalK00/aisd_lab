package L4.z5;


public interface StackZ5Interface<Double>{

    boolean isEmpty();
    double pop() throws EmptyStackException;
    void push(double elem);
    int size();
    double top() throws EmptyStackException;
}
