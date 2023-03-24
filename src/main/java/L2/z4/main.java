package L2.z4;

public class main {

    public static void main(String[] args) {
        System.out.println("n większe od k:");
        System.out.println("Miejsca:");
        findLastTwoValues(3, 29);
        System.out.println();
        System.out.println("k większe od n:");

        System.out.println("Miejsca:");
        findLastTwoValues(5, 4);
        System.out.println();

        System.out.println("n równe 2:");
        System.out.println("Miejsca:");
        findLastTwoValues(3, 2);
        System.out.println();

    }
    public static OneWayCycleList findLastTwoValues(int k, int n){
        if(n==2){
            System.out.println("Mogą się po prostu poddać");
            return null;
        }

        OneWayCycleList list = new OneWayCycleList<>();
        for(int x = 1; x<=n; x++){
            list.add(x);
        }

        OneWayCycleList.Element currentElement;
        OneWayCycleList.Element iteratingElement = list.sentinel.getNext();
        while(list.size()!=2){
            currentElement = iteratingElement;
            for(int x = 0; x < k; x++){
                if(currentElement.getValue()==null){
                    currentElement = currentElement.getNext();
                }
                currentElement = currentElement.getNext();
            }
            if(currentElement.getValue()==null){
                currentElement = currentElement.getNext();
            }

            list.remove(currentElement.getValue());
            iteratingElement = iteratingElement.getNext();
            if(iteratingElement.getValue()==null){
                iteratingElement = iteratingElement.getNext();
            }
        }
        list.printWholeList();
        return list;
    }
}
