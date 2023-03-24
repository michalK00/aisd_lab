package L3.z2;


import java.util.Random;

public class main {

    public static void main(String[] args) throws Exception {

        OneWayLinkedQueue<Integer> queue = new OneWayLinkedQueue<>();
        Bufor bufor = new Bufor(6);
        for(int x = 1; x<15;x++){
            queue.enqueue(x);
        }
        Random random = new Random();
        while(!queue.isEmpty()){

            while(!bufor.isFull()){
                int a = queue.dequeue();
                bufor.enqueue(a);
                System.out.println("Dodano do bufora: ");
                System.out.println(a);
                System.out.println();
            }

            System.out.println("Aktualna zawartość bufora:");
            bufor.printQueue();
            System.out.println();

            if((random.nextInt(3) == 1) && !bufor.isEmpty()){
                int a  = bufor.dequeue();
                System.out.println("Wyrzucono z bufora: ");
                System.out.println(a);
                System.out.println();
            }

        }
        while (!bufor.isEmpty()){
            int a  = bufor.dequeue();
            System.out.println("Wyrzucono z bufora: ");
            System.out.println(a);
            System.out.println();
        }

    }
}
