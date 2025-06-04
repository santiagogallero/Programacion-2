package org.example.model;

public class ParenthesisChecker {
    public static boolean checkParentheses(String text) {
        CharStack6 stack = new CharStack6(text.length());
        for (char c : text.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.getTop() != '(') {
                    return false;
                }
                stack.remove();
            }
        }
        return stack.isEmpty();
    }
    public  static boolean checkBracketsAndBraces(String text){
        CharStack6 stack = new CharStack6(text.length());
        for (char c : text.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.getTop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
                stack.remove();
            }
        }
        return stack.isEmpty();
    }
}
