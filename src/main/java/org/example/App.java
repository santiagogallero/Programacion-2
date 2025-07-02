package org.example;

import org.example.model.*;
import org.example.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        ISet conjunto = new ArraySet();

        conjunto.add(5);
        conjunto.add(10);
        conjunto.add(5); // No debería agregarse

        System.out.println("¿Está vacío?: " + conjunto.isEmpty()); // false
        System.out.println("Elemento elegido: " + conjunto.choose()); // 5 o 10
    }

    }

