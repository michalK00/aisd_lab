package L2.z2;

import java.util.AbstractList;
import java.util.Iterator;

public class OneWayLinkedListWithHead<E> extends AbstractList<E> {

    Element head = null;

    public OneWayLinkedListWithHead() {}

    public boolean isEmpty(){
        return head==null;
    }

    @Override
    public void clear() {
        head=null;
    }

    @Override
    public int size() {
        int pos = 0;
        Element currentElement = head;
        while(currentElement!=null){
            pos++;
            currentElement=currentElement.getNext();
        }
        return pos;
    }

    @Override
    public boolean add(E e) {
        Element newElem = new Element(e);
        if(head==null){
            head=newElem;
            return true;
        }
        Element tail = head;
        while(tail.getNext()!=null){
            tail=tail.getNext();
        }
        tail.setNext(newElem);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(index<0){
            throw new IndexOutOfBoundsException();
        }
        Element newElement = new Element(element);
        if(index==0){
            newElement.setNext(head);
            head=newElement;
        }else{
            Element activeElement = getElement(index-1);
            newElement.setNext(activeElement.getNext());
            activeElement.setNext(newElement);
        }
    }

    private Element getElement(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        Element activeElement = head;
        while (index>0 && activeElement!=null){
            index--;
            activeElement = activeElement.getNext();
        }
        if(activeElement==null){
            throw new IndexOutOfBoundsException();
        }
        return activeElement;
    }
    @Override
    public E get(int index) {
        Element activeElement = getElement(index);
        return activeElement.getValue();
    }

    @Override
    public E set(int index, E element) {
        Element activeElement = getElement(index);
        E elementData = activeElement.getValue();
        activeElement.setValue(element);
        return elementData;
    }

    @Override
    public E remove(int index) {
        if(index<0 || head==null){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            E value = head.getValue();
            head = head.getNext();
            return value;
        }
        Element activeElement = getElement(index);
        if(activeElement.getValue()==null){
            throw new IndexOutOfBoundsException();
        }
        E value = activeElement.getNext().getValue();
        activeElement.setNext(activeElement.getNext().getNext());
        return value;
    }
    @Override
    public boolean remove(Object value) {
        if(head==null)
            return false;
        if(head.getValue().equals(value)){
            head=head.getNext();
            return true;}
        Element actElem=head;
        while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value))
            actElem=actElem.getNext();
        if(actElem.getNext()==null)
            return false;
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }
    public boolean removeAllObjectsWithKey(Object value){
        if(head==null) {
            return false;
        }
        Element activeElement = head;
        while(activeElement.getNext()!=null){
            remove(value);
            activeElement = activeElement.getNext();
        }
        return true;
    }


    @Override
    public int indexOf(Object o) {
        int position = 0;
        Element activeElement=head;
        while(activeElement!=null){
            if(activeElement.getValue().equals(o)){
                return position;
            }
            position++;
            activeElement=activeElement.getNext();
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)>=0;
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public boolean equals(Object o) {
        throw  new UnsupportedOperationException();
    }

    public void printWholeList(){
        Element activeElement = head;
        while (activeElement!=null){
            System.out.println(activeElement.getValue());
            activeElement = activeElement.getNext();
        }
    }
    public class Element {

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


    private class InnerIterator implements Iterator<E>{
        Element actElem;
        public InnerIterator() {
            actElem=head;
        }
        @Override
        public boolean hasNext() {
            return actElem!=null;
        }
        @Override
        public E next() {
            E value = actElem.getValue();
            actElem=actElem.getNext();
            return value;
        }

    }

}

