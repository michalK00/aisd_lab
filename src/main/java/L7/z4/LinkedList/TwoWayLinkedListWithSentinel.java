package L7.z4.LinkedList;


import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

public class TwoWayLinkedListWithSentinel<E> extends AbstractList<E> {

    Element sentinel=null;

    public TwoWayLinkedListWithSentinel() {
        sentinel=new Element(null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }
    public Element getElement(int index){
        if(index<0) throw new IndexOutOfBoundsException();
        Element elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && counter<index){
            counter++;
            elem=elem.getNext();}
        if(elem==sentinel)
            throw new IndexOutOfBoundsException();
        return elem;
    }
    public Element getElement(E value){
        Element elem=sentinel.getNext();
        while(elem!=sentinel && !value.equals(elem.getValue())){
            elem=elem.getNext();}
        if(elem==sentinel)
            return null;
        return elem;
    }
    public boolean isEmpty(){
        return sentinel.getNext()==sentinel;
    }
    public void clear(){
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value)!=-1;
    }

    public E get(int index){
        Element element = getElement(index);
        return element.getValue();
    }

    public E set(int index, E value){
        Element element = getElement(index);
        E returnedValue = element.getValue();
        element.setValue(value);
        return returnedValue;
    }
    public boolean add(E value){
        Element newElement = new Element(value);
        sentinel.insertBefore(newElement);
        return true;
    }
    public void add(int index, E value){
        Element newElement = new Element(value);
        if(index==0){
            sentinel.insertAfter(newElement);
        }else {
            Element element = getElement(index-1);
            element.insertAfter(newElement);
        }
    }
    public int indexOf(Object value){
        Element element = sentinel.getNext();
        int index = 0;
        while(element!=sentinel && !element.getValue().equals(value)){
            index++;
            element=element.getNext();
        }
        if(element==sentinel){
            return -1;
        }
        return index;
    }


    public E remove(int index){
        Element element = getElement(index);
        element.remove();
        return element.getValue();
    }

    public boolean remove(Object value){
        Element element = getElement((E) value);
        if(element==null){
            return false;
        }
        element.remove();
        return true;
    }


    @Override
    public int size() {
        Element element = sentinel.getNext();
        int size = 0;
        while (element!=sentinel){
            size++;
            element = element.getNext();
        }
        return size;
    }

    public Iterator<E> interator(){
        return new TWCLWSIterator();
    }

    private class TWCLWSIterator implements Iterator<E>{
        Element currentElement = sentinel;

        public boolean hasNext() {
            return currentElement.getNext()!=sentinel;
        }

        public E next() {
            currentElement=currentElement.getNext();
            return currentElement.getValue();
        }
    }
    private class TWCLWSListIteraor implements ListIterator<E> {
        boolean wasNext = false;
        boolean wasPrevious = false;

        Element currentElement = sentinel;
        public boolean hasNext() {
            return currentElement.getNext()!=sentinel;
        }
        public boolean hasPrevious() {
            return currentElement!=sentinel;
        }
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
        public E next() {
            wasNext=true;
            wasPrevious=false;
            currentElement=currentElement.getNext();
            return currentElement.getValue();
        }
        public E previous() {
            wasNext=false;
            wasPrevious=true;
            E retValue=currentElement.getValue();
            currentElement=currentElement.getPrev();
            return retValue;
        }
        public void remove() {
            if(wasNext){
                Element curr=currentElement.getPrev();
                currentElement.remove();
                currentElement=curr;
                wasNext=false;
            }
            if(wasPrevious){
                currentElement.getNext().remove();
                wasPrevious=false;
            }
        }
        public void add(E data) {
            Element newElem=new Element(data);
            currentElement.insertAfter(newElem);
            currentElement=currentElement.getNext();
        }
        public void set(E data) {
            if(wasNext){
                currentElement.setValue(data);
                wasNext=false;
            }
            if(wasPrevious){
                currentElement.getNext().setValue(data);
                wasNext=false;
            }
        }
    }
    public void printWholeList(){
        Element element = sentinel;
        while(element.getNext()!=sentinel){
            element = element.getNext();
            System.out.println(element.getValue());
        }
    }
    public void printWholeListBackwordsUsingGetPrev(){
        Element element = sentinel;
        while(element.getPrev()!=sentinel){
            element = element.getPrev();
            System.out.println(element.getValue());
        }
    }

    public class Element{
        private E value;
        private Element next;
        private Element prev;

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
        public Element getPrev() {
            return prev;
        }
        public void setPrev(Element prev) {
            this.prev = prev;
        }
        Element(E data){
            this.value=data;
        }
        public void insertAfter(Element elem){
            elem.setNext(this.getNext());
            elem.setPrev(this);
            this.getNext().setPrev(elem);
            this.setNext(elem);
        }
        public void insertBefore(Element elem){
            elem.setNext(this);
            elem.setPrev(this.getPrev());
            this.getPrev().setNext(elem);
            this.setPrev(elem);
        }
        public void remove(){
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
        }
    }
}
