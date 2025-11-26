import java.util.Stack;

public class HTMLValidator {
    public static boolean isValidHTML(String[] htmlLines) {
        Stack<String> stack = new Stack<>();

        for (String line : htmlLines) {
            if (line.matches("<[^/].*?>")) {
                stack.push(line);
            } else if (line.matches("</.*?>")) {
                if (stack.isEmpty() || !matches(stack.peek(), line)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean matches(String openTag, String closeTag) {
        return closeTag.equals("</" + openTag.substring(1));
    }

    public static void main(String[] args) {

        String[] validHTML = {
                "<html>", "<body>", "<h1>", "</h1>", "</body>", "</html>"
        };

        String[] invalidHTML = {
                "<html>", "<body>", "<h1>", "</body>", "</h1>", "</html>"
        };

        System.out.println("Geçerli HTML: " + isValidHTML(validHTML));
        System.out.println("Geçersiz HTML: " + isValidHTML(invalidHTML));
    }
}
