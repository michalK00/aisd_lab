package L2.z4;

import java.io.Serializable;
import java.util.Iterator;

public class OneWayCycleList<E> implements OneWayCycleListInterface<E>{

    Element sentinel = null;

    public OneWayCycleList() {
        sentinel=new Element(null);
        sentinel.setNext(sentinel);
    }

    public boolean isEmpty(){
        return sentinel == null;
    }

    @Override
    public void clear() {
        sentinel = null;
    }

    @Override
    public int size() {
        int pos = 0;
        Element currentElement = sentinel.getNext();
        while(currentElement!=sentinel){
            pos++;
            currentElement=currentElement.getNext();
        }
        return pos;
    }

    @Override
    public boolean add(E e) {
        Element newElem = new Element(e);
        if(sentinel.getNext()==null){
            sentinel.setNext(newElem);
            sentinel.getNext().setNext(sentinel);
            return true;
        }
        Element tail = sentinel;
        while(tail.getNext()!=sentinel){
            tail=tail.getNext();
        }
        tail.setNext(newElem);
        newElem.setNext(sentinel);
        return true;
    }

    public Element getElement(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        Element activeElement = sentinel.getNext();
        while (index>0 && activeElement!=sentinel){
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
    public int indexOf(E o) {
        int position = 0;
        Element activeElement=sentinel.getNext();
        while(activeElement.getNext()!=sentinel){
            if(activeElement.getValue().equals(o)){
                return position;
            }
            position++;
            activeElement=activeElement.getNext();
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if(index<0 || sentinel.getNext()==null){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            E value = sentinel.getValue();
            sentinel = sentinel.getNext();
            return value;
        }
        Element activeElement = getElement(index);
        if(activeElement.getValue()==null){
            throw new IndexOutOfBoundsException();
        }
        E value = activeElement.getValue();
        activeElement.setNext(activeElement.getNext().getNext());
        return value;
    }
    @Override
    public boolean remove(Object value) {
        if(sentinel.getNext().getValue()==null)
            return false;
        if(sentinel.getNext().getValue().equals(value)){
            sentinel.setNext(sentinel.getNext().getNext());
            return true;
        }
        Element actElem=sentinel.getNext();
        while(actElem.getNext().getValue()!=null && !(actElem.getNext().getValue()==value))
            actElem=actElem.getNext();
        if(actElem.getNext()==null)
            return false;
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    public void printWholeList(){
        Element activeElement = sentinel.getNext();
        while (activeElement!=sentinel){
            System.out.println(activeElement.getValue());
            activeElement = activeElement.getNext();
        }
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


    private class InnerIterator implements Iterator<E> {
        Element actElem;
        public InnerIterator() {
            actElem=sentinel.getNext();
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
