package Strings;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        validParenthesis();
    }

    public static void validParenthesis(){
        String paren = "[{()}]";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < paren.length(); i++){
            if (stack.isEmpty()){
                stack.add(paren.charAt(i));
            } else if (stack.peek().equals('{') && paren.charAt(i) == '}'
            || stack.peek().equals('(') && paren.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.add(paren.charAt(i));
            }
        }

        if (stack.isEmpty()){
            System.out.println("Valid Parenthesis");
        } else {
            System.out.println("Not valid parenthesis");
        }
    }
}

