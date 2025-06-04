package org.example.model;

import java.util.ArrayList;

public class DynamicStack implements IStack {
   private ArrayList<Integer> stack;

   public DynamicStack() {
       this.stack = new ArrayList<>();
   }
   public void add(int a) {
       stack.add(a);
   }
   public void remove(){
       if (stack.isEmpty()) {
           System.out.println("Error, no se puede desapilar una pila vacía");
           return;
       }
       stack.remove(stack.size() - 1);
   }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    @Override
    public int getTop() {
        if (stack.isEmpty()) {
            System.out.println("Error, no se puede desapilar una pila vacía");
            return -1;
        }
        return stack.get(stack.size() - 1);
    }
}
