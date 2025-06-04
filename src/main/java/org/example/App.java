package org.example;

import org.example.model.*;
import org.example.model.IStack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {

        IStack stack = new StaticStack();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        ((StaticStack)stack).revert();
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
            System.out.println();
        }

        IStack stack2= new StaticStackDoubleAdd2(100);
        System.out.println("StaticStackDoubleAdd");
        stack2.add(1);
        stack2.add(2);
        stack2.add(3);
        stack2.add(4);

        while(!stack2.isEmpty()){

            System.out.println(stack2.getTop());
            stack2.remove();
        }
        IStack stack3= new StaticStackNAddMRemove3(1,1,100);
        stack3.add(1);
        stack3.add(2);
        stack3.add(3);
        stack3.add(4);
        System.out.println("StaticStackNAddMRemove");
        while(!stack3.isEmpty()){

            System.out.println(stack3.getTop());
            stack3.remove();
        }
        // Ejemplo con DynamicStack
        System.out.println("DynamicStack");
        DynamicStack dynamicStack = new DynamicStack();
        dynamicStack.add(10);
        dynamicStack.add(20);
        dynamicStack.add(30);
        while (!dynamicStack.isEmpty()) {
            System.out.println(dynamicStack.getTop());
            dynamicStack.remove();
        }

        // Ejemplo con CharStack
        System.out.println("\nCharStack");
        CharStack6 charStack = new CharStack6(5);
        charStack.add('A');
        charStack.add('B');
        charStack.add('C');
        while (!charStack.isEmpty()) {
            System.out.println(charStack.getTop());
            charStack.remove();
        }

        // Ejemplo con ParenthesisChecker
        System.out.println("\nParenthesisChecker");
        String test1 = "(a + b) * (c + d)";
        String test2 = "(a + b * (c - d)";
        System.out.println("Test 1: " + ParenthesisChecker.checkParentheses(test1)); // true
        System.out.println("Test 2: " + ParenthesisChecker.checkParentheses(test2)); // false

        // Ejemplo con checkBracketsAndBraces
        System.out.println("\nCheck Brackets and Braces");
        String test3 = "{[()]}";
        RepeatedStackTDA pila = new RepeatedStackTDA(10);
        int[] datos = {1, 6, 8, 1, 1, 3, 3, 3, 3, 6};
        for (int n : datos) {
            pila.add(n);
        }
        System.out.println(pila);

    }
}
