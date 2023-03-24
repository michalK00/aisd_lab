package L3.z1;

public class test {

    public static void main(String[] args) throws Exception {
        OneWayLinkedQueue queue = new OneWayLinkedQueue();
        System.out.println("INPUT:");
        queue.enqueue("Pierwszy");
        System.out.println("Dodano: Pierwszy");
        queue.enqueue("Drugi");
        System.out.println("Dodano: Drugi");
        queue.enqueue("Trzeci");
        System.out.println("Dodano: Trzeci");
        queue.enqueue("Czwarty");
        System.out.println("Dodano: Czwarty");
        queue.enqueue("Piąty");
        System.out.println("Dodano: Piąty");

        System.out.println();

        System.out.println("Wypisywanie elementów z kolejki:");
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
        OneWayLinkedQueue queue2 = new OneWayLinkedQueue();
        System.out.println(queue.dequeue());



    }
}
