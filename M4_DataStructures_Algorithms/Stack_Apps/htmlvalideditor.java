import java.util.Stack;

public class htmlvalideditor {

    public static boolean isValidHTML(String html) {
        Stack<String> stack = new Stack<>();

        String[] tags = html.split("(?=<)|(?<=>)");

        for (String tag : tags) {
            if (tag.startsWith("<") && tag.endsWith(">")) {
                if (tag.matches("<.*?/>")) {
                    continue;
                }

                if (tag.startsWith("<") && !tag.startsWith("</")) {
                    String tagName = tag.substring(1, tag.length() - 1);
                    stack.push(tagName);
                }
                else if (tag.startsWith("</")) {
                    if (stack.isEmpty() || !stack.peek().equals(tag.substring(2, tag.length() - 1))) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String validHTML = "<html><body><h1>Hello World</h1></body></html>";
        String invalidHTML = "<html><body><h1>Hello World</body></html>";
       

        System.out.println("Geçerli HTML mi? " + isValidHTML(validHTML));
        System.out.println("Geçersiz HTML mi? " + isValidHTML(invalidHTML));

    }
}