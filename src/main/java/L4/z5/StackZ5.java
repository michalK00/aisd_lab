package L4.z5;

public class StackZ5<Double> implements StackZ5Interface<Double>{

    Element head = null;

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public double pop() {
        Element element = head;
        head = head.getNext();
        return element.getValue();
    }

    @Override
    public void push(double elem) {
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
    public double top() throws EmptyStackException {
        return head.getValue();
    }

    private class Element{

        private double value;
        private Element next;

        public double getValue() {
            return value;
        }
        public void setValue(double value) {
            this.value = value;
        }
        public Element getNext() {
            return next;
        }
        public void setNext(Element next) {
            this.next = next;
        }
        Element(double data){
            this.value=data;
        }
    }
}
class EmptyStackException extends Exception{
    public EmptyStackException(String message) {
        super(message);
    }
}
