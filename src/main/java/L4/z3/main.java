package L4.z3;



public class main {

    public static void main(String[] args) throws EmptyStackException {
        DrowningStack stack = new DrowningStack<>(5);
        System.out.println("Lista o rozmiarze 4");

        stack.push("Pierwszy");
        stack.push("Drugi");
        stack.push("Trzeci");
        stack.push("Czwarty");
        System.out.println("Wypisanie listy:");
        stack.printStack();
        System.out.println();
        System.out.println("Dodanie elementy Piąty");
        stack.push("Piąty");
        System.out.println("Wypisanie listy:");
        stack.printStack();
        System.out.println();

        System.out.println("Wyciąganie dodanych elementów:");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("Próba wyciągnięcia elementu z pustego stosu:");
        DrowningStack stack2 = new DrowningStack();
        System.out.println(stack2.pop());
    }
}
