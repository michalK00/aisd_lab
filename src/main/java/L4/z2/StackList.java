package L4.z2;


public class StackList<E> implements StackListInterface<E> {

    Element head = null;

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty");
        }
        Element element = head;
        head = head.getNext();
        return element.getValue();
    }

    @Override
    public void push(E elem) {
        Element element = new Element(elem);
        if(isEmpty()){
            head = element;
        } else {
            element.setNext(head);
            head = element;
        }

    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E top() throws EmptyStackException {
        return head.getValue();
    }

    public class Element{

        private E value;
        private Element next;

        public E getValue() {
            return value;
        }
        public void setValue(E value) {
            this.value = value;
        }
        public Element getNext() {
            return next;
        }
        public void setNext(Element next) {
            this.next = next;
        }
        Element(E data){
            this.value=data;
        }
    }
}
class EmptyStackException extends Exception{
    public EmptyStackException(String message) {
        super(message);
    }
}

