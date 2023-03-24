package L4.z2;


public class main {
    public static void main(String[] args) throws EmptyStackException {

        System.out.println("Dodane elementy w kolejności:");
        System.out.println("Pierwszy");
        System.out.println("Drugi");
        System.out.println("Trzeci");
        System.out.println("Czwarty");
        System.out.println("Piąty");

        StackList stack = new StackList();
        stack.push("Pierwszy");
        stack.push("Drugi");
        stack.push("Trzeci");
        stack.push("Czwarty");
        stack.push("Piąty");

        System.out.println("Wyciąganie dodanych elementów:");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        System.out.println("Próba wyciągnięcia elementu z pustego stosu:");
        StackList stack2 = new StackList();
        System.out.println(stack2.pop());
    }
}
