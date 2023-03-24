package L4.z4;


public class main {
    public static void main(String[] args) throws EmptyStackException {
        SelfExpandingStack stack = new SelfExpandingStack<>();



        stack.push("Pierwszy");
        System.out.println(stack.size());
        stack.push("Drugi");
        System.out.println(stack.size());
        stack.push("Trzeci");
        System.out.println(stack.size());
        stack.push("Czwarty");
        System.out.println(stack.size());
        stack.push("Piąty");
        System.out.println(stack.size());
        System.out.println();
        System.out.println("Cały stos:");
        stack.printStack();
        System.out.println();

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
            System.out.println(stack.size());
        }

        System.out.println();
        System.out.println("Cały stos:");
        stack.printStack();
        System.out.println();

        SelfExpandingStack stack2 = new SelfExpandingStack();
        System.out.println(stack2.pop());
    }
}
