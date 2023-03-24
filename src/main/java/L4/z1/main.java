package L4.z1;

public class main {

    public static void main(String[] args) throws FullStackException, EmptyStackException {

        System.out.println("Dodane elementy w kolejności:");
        System.out.println("Pierwszy");
        System.out.println("Drugi");
        System.out.println("Trzeci");
        System.out.println("Czwarty");
        System.out.println("Piąty");

        Stack stack = new Stack();
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
        Stack stack2 = new Stack();
        System.out.println(stack2.pop());
    }
}
