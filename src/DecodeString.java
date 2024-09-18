import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (c == ']') {
                StringBuilder sbHelper = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sbHelper.append(stack.pop());
                }
                stack.pop(); // removing the "["

                String digit = "";
                // pop the number
                while (stack.size() > 0 && isNumeric(stack.peek())) {
                    digit = stack.pop() + digit;
                }

                // storing the sbHelper string digit times
                int i = Integer.parseInt(digit);
                sbHelper = sbHelper.reverse();
                String temp = sbHelper.toString();
                while (i > 0) {
                    // save temp chars to stack for digit times
                    for (int k = 0; k < temp.length(); k++) {
                        stack.push(temp.substring(k, k + 1));
                    }
                    i--;
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }

        // retrieve elements from stack and build string to return
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().substring(0, sb.length());
    }

    static boolean isNumeric(String d) {
        try {
            Integer.parseInt(d);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("100[leetcode]"));
    }
}
