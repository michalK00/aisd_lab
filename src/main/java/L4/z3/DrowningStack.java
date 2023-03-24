package L4.z3;


public class DrowningStack<T> implements DrowningStackInterface<T>{


    private static final int DEFAULT_CAPACITY = 10;
    T array[];
    int begin;
    int end;

    @SuppressWarnings("unchecked")
    public DrowningStack(int initialSize) {
        array=(T[])(new Object[initialSize]);
        begin = 5%initialSize;
        end = 5%initialSize;
    }

    public DrowningStack (){
        this(DEFAULT_CAPACITY);
        begin = 3;
        end = 3;
    }

    @Override
    public boolean isEmpty() {
        return begin==end;
    }

    @Override
    public boolean isFull() {
        return begin==(end+1)%array.length;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Stack is empty");
        T retValue;
        end--;
        if(end<0){
            end = array.length-1;
        }
        end%=array.length;
        retValue = array[end];
        return retValue;
    }

    @Override
    public void push(T elem) {
        if(isFull()){
            begin++;
            begin%=array.length;
            array[end++]=elem;
            end%=array.length;
        } else {
            array[end++]=elem;
            end%=array.length;
        }
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public T top() throws EmptyStackException {
        return array[end];
    }
    public void printStack(){
        for(int x = 0; x<array.length-1;x++){
            System.out.println(array[(begin+x)%array.length]);
        }
    }
}
class EmptyStackException extends Exception{
    public EmptyStackException(String message) {
        super(message);
    }
}
