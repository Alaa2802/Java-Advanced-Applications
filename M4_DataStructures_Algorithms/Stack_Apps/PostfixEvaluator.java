import java.util.Stack;
import java.util.Scanner;

public class PostfixEvaluator {


    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Geçersiz ifade :(");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Sıfıra bölme hatası :(");
                        }
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Bilinmeyen operatör :| " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Geçersiz ifade :( ");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Postfix ifadeyi girin : ");
        String expression = scanner.nextLine();

        try {
            int result = evaluatePostfix(expression);
            System.out.println("Sonuç => " + result);
        } catch (Exception e) {
            System.out.println("Hata :| " + e.getMessage());
        }

        scanner.close();
    }
}
