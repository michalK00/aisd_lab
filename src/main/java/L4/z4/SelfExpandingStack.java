package L4.z4;

public class SelfExpandingStack <T> implements SelfExpandingStackInterface{

    private static final int DEFAULT_CAPACITY = 2;
    T array[];
    int top;

    public SelfExpandingStack (){
        array=(T[])(new Object[DEFAULT_CAPACITY]);
        top = 0;
    }


    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Stack is empty");

        float ratio = Float.valueOf(top)/Float.valueOf(size());
//        System.out.println(ratio);
        if(ratio<=0.25){
            reduceStackSize();
        }
        System.out.println("Usunięto element");
        return array[--top];
    }

    @Override
    public void push(Object elem) {
        float ratio = Float.valueOf(top)/Float.valueOf(size());
//        System.out.println(ratio);
        if(ratio>=0.75){
            enlargeStackSize();
        }
        array[top++]= (T) elem;
        System.out.println("Dodano element");
    }


    @Override
    public int size() {
        System.out.println("Rozmiar:");
        return array.length;
    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty");
        }
        return array[top-1];
    }

    private void enlargeStackSize(){
        T array2[] = (T[])(new Object[array.length*2]);
        for(int x = 0; x<top;x++){
            array2[x] = array[x];
        }
        array = array2;
    }
    private void reduceStackSize(){
        T array2[] = (T[])(new Object[array.length/2]);
        for(int x = 0; x<top;x++){
            array2[x] = array[x];
        }
        array = array2;
    }
    public void printStack(){
        if(isEmpty()){
            System.out.println("Stos pusty");
        } else{
            for(int x = 0; x<top;x++){
                System.out.println(array[x]);
            }
        }
    }
}
class EmptyStackException extends Exception{
    public EmptyStackException(String message) {
        super(message);
    }
}
