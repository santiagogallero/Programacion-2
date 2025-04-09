package org.example;

import org.example.model.IStack;
import org.example.model.StaticStack;
import org.example.model.StaticStackDoubleAdd;
import org.example.model.StaticStackNAddMRemove;

import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        IStack stack= new StaticStack();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        while(!stack.isEmpty()){
            System.out.println(stack.getTop());
            stack.remove();
            System.out.println();
        }

        IStack stack2= new StaticStackDoubleAdd(100);
        System.out.println("StaticStackDoubleAdd");
        stack2.add(1);
        stack2.add(2);
        stack2.add(3);
        stack2.add(4);
        while(!stack.isEmpty()){

            System.out.println(stack2.getTop());
            stack.remove();
        }
        IStack stack3= new StaticStackNAddMRemove(5,5,100);
        stack3.add(1);
        stack3.add(2);
        stack3.add(3);
        stack3.add(4);
        System.out.println("StaticStackNAddMRemove");
        while(!stack3.isEmpty()){

            System.out.println(stack3.getTop());
            stack3.remove();
        }
    }
}