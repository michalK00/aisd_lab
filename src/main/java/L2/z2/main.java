package L2.z2;

public class main {

    public static void main(String[] args) {
        OneWayLinkedListWithHead<Student> list1 = new OneWayLinkedListWithHead<>();

        System.out.println("INPUT:");
        System.out.println("Lista 1:");
        list1.add(new Student("Adam","Adamowski",123,5.0));
        list1.add(new Student("Bartosz","Bartoszewski",234,4.0));
        list1.add(new Student("Cyprian","Cypriański",245,2.0));
        list1.add(new Student("Damian","Damianowski",299,3.0));
        list1.printWholeList();
        OneWayLinkedListWithHead<Student> list2 = new OneWayLinkedListWithHead<>();
        System.out.println();
        System.out.println("Lista 2:");
        list2.add(new Student("Adam","Nowak",200,5.0));
        list2.add(new Student("Edward","Edwardowski",501,4.0));
        list2.add(new Student("Fabian","Fabianowski",550,2.0));
        list2.add(new Student("Grzegorz","Grzegocki",700,3.0));
        list2.printWholeList();

        System.out.println();
        System.out.println("Połączona i posortowana po indeksie lista 3:");
        mergeTwoLists(list1,list2).printWholeList();







    }

    public static OneWayLinkedListWithHead<Student> mergeTwoLists(OneWayLinkedListWithHead<Student> l1, OneWayLinkedListWithHead<Student> l2){

        OneWayLinkedListWithHead<Student> output = new OneWayLinkedListWithHead<>();
        OneWayLinkedListWithHead<Student>.Element l1Element = l1.head;
        OneWayLinkedListWithHead<Student>.Element l2Element = l2.head;



        while(l1Element!=null && l2Element!=null){
            if(l1Element.getValue().getIndexNumber()<=l2Element.getValue().getIndexNumber()){
                output.add(l1Element.getValue());
                l1Element=l1Element.getNext();
            }else{
                output.add(l2Element.getValue());
                l2Element=l2Element.getNext();
            }
        }
        if(l1Element==null){
            while(l2Element!=null){
                output.add(l2Element.getValue());
                l2Element=l2Element.getNext();
            }
        }
        if(l2Element==null){
            while(l1Element!=null){
                output.add(l1Element.getValue());
                l1Element=l1Element.getNext();
            }
        }

        return output;

    }

}
