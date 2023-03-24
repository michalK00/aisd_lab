package L3.z2;


public class Bufor{


    int[] bufor;
    int begin = 3;
    int end = 3;

    public Bufor(int size) {
        bufor = new int[size];
    }

    public boolean isEmpty() {
        return begin==end;
    }

    public boolean isFull(){
        return begin==(end+1)%bufor.length;
    }

    public void enqueue(int a) throws FullQueueException {
        if(isFull())
            throw new FullQueueException("Queue is full");
        bufor[end++]=a;
        end%=bufor.length;
    }

    public int dequeue() throws Exception {
        if(isEmpty())
            throw new EmptyQueueException("Queue is empty");
        int retValue=bufor[begin++];
        begin%=bufor.length;
        return retValue;
    }

    public int size() {
        return bufor.length;
    }

    public void printQueue(){
        for(int x = 0; x<bufor.length-1;x++){
            System.out.println(bufor[(begin+x)%bufor.length]);
        }
    }

}
class EmptyQueueException extends Exception{
    public EmptyQueueException(String message) {
        super(message);
    }
}
class FullQueueException extends Exception{
    public FullQueueException(String message) {
        super(message);
    }
}



