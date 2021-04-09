package ru.job4j.collection;

import java.util.Stack;

public class Parentheses {
    public static boolean valid(char[] data) {
        Stack<Character> stack = new Stack<>();
        for (char c : data) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                if (top == '[' && c != ']') {
                    return false;
                }
                if (top == '(' && c != ')') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}