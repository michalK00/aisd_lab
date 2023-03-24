package L3.z3;


import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws Exception {

        ArrayList<Klient> list = new ArrayList();
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());
        list.add(new Klient());

        printArray(list);
        sortByArrivalTime(list);
        System.out.println("Wprowadzona lista Klientów");
        printArray(list);
        simulate(list);
    }
    public static void sortByArrivalTime(ArrayList<Klient> list){

        boolean sorted = false;
        Klient temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getArrivalTime() > list.get(i+1).getArrivalTime()) {
                    temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                    sorted = false;
                }
            }
        }

    }
    public static void printArray(ArrayList<Klient> list){
        for (int x =0; x < list.size();x++){
            System.out.println(list.get(x));
        }
    }
    public static void simulate(ArrayList<Klient> list) throws Exception {
        int time=0;
        OneWayLinkedQueue<Klient> queue = new OneWayLinkedQueue();
        ArrayList<Klient> done = new ArrayList();


        ArrayList<Urzędnik> listaUrzednikow = new ArrayList();
        listaUrzednikow.add(new Urzędnik("A"));
        listaUrzednikow.add(new Urzędnik("B"));
        listaUrzednikow.add(new Urzędnik("C"));

        //dopóki done będzie wielkości list to pętla działa
        while(!(done.size() == list.size())){

            for(int x = 0; x<list.size();x++){
                if(list.get(x).getArrivalTime()==time){
                    queue.enqueue(list.get(x));
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
                queue.printQueue();
                System.out.println();
            }
            for(int x = 0; x<listaUrzednikow.size();x++){
                if(!listaUrzednikow.get(x).isFree()){
                    listaUrzednikow.get(x).getCurrentKlient().setProcessingTime(listaUrzednikow.get(x).getCurrentKlient().getProcessingTime()-1);
                    if(listaUrzednikow.get(x).getCurrentKlient().getProcessingTime()==0){
                        System.out.println("Zakończono obsługę: " + listaUrzednikow.get(x).getCurrentKlient());
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
