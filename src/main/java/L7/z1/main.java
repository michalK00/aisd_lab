package L7.z1;

import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args) throws Exception {
        simulate();
    }

    public static void simulate() throws Exception {
        int time=1;

        ReversedHeap queue = new ReversedHeap();
        ArrayList<Klient> done = new ArrayList();
        Random r = new Random();

        ArrayList<Urzędnik> listaUrzednikow = new ArrayList();
        listaUrzednikow.add(new Urzędnik("A"));
        listaUrzednikow.add(new Urzędnik("B"));
        listaUrzednikow.add(new Urzędnik("C"));
        int a = 0;
        //dopóki done będzie wielkości list to pętla działa
        while((!queue.isEmpty() || a<=30)){

            if(a<=30){
                a++;
                if(r.nextInt(10)>3){
                    Klient k1 = new Klient();
                    queue.enqueue(k1);
                    System.out.println("Dodano klienta: "+ k1);
                    if(r.nextInt(10)>8){
                        Klient k2 = new Klient();
                        queue.enqueue(k2);
                        System.out.println("Dodano klienta: "+ k2);
                    }
                }
            }

            if(!queue.isEmpty()){
                for(int x = 0; x<listaUrzednikow.size();x++){
                    if(listaUrzednikow.get(x).isFree() && !queue.isEmpty()){
                        listaUrzednikow.get(x).setCurrentKlient(queue.dequeue());
                        listaUrzednikow.get(x).setFree(false);
                    }
                }
                System.out.println("Aktualny stan kolejki:");
                queue.printList();
                System.out.println();
            }
            for(int x = 0; x<listaUrzednikow.size();x++){
                if(!listaUrzednikow.get(x).isFree()){
                    listaUrzednikow.get(x).getCurrentKlient().setProgress(listaUrzednikow.get(x).getCurrentKlient().getProgress()+1);
                    if(listaUrzednikow.get(x).getCurrentKlient().getProgress()==listaUrzednikow.get(x).getCurrentKlient().getProcessingTime()){
                        System.out.println("Urzędnik nr. " +x+" zakończył obsługę");
                        System.out.println(listaUrzednikow.get(x).getCurrentKlient());
                        System.out.println("czas: " + time);
                        System.out.println();
                        listaUrzednikow.get(x).setCurrentKlient(null);
                        listaUrzednikow.get(x).setFree(true);
                        done.add(listaUrzednikow.get(x).getCurrentKlient());
                    }
                }
            }

            time++;
        }
    }
}
