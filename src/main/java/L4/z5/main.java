package L4.z5;

public class main {
    public static void main(String[] args) {
        StackZ5 stack = new StackZ5();
        String input = "2 7 + 3 / 14 3 - 4 * + 2 /";
        System.out.println("Input:");
        System.out.println(input);
        System.out.println("Wynik:");
        System.out.println(calculate(input,stack));
    }
    public static double calculate(String input, StackZ5<Double> stack){
        String[] trimmedArray = input.trim().split("\\s+");

        double x, y;
        for (String expression : trimmedArray) {
            switch (expression) {
                case "+" -> {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y + x);
                }
                case "-" -> {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y - x);
                }
                case "*" -> {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(x * y);
                }
                case "/" -> {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y / x);
                }
                default -> stack.push(Double.parseDouble(expression));
            }
        }
        return stack.pop();
    }
}
