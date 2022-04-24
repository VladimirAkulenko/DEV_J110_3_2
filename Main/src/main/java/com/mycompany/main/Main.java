/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.main;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
       Integer[] numbers = {1,2,3,4,5};
    ArrayList<Integer> collection = new ArrayList<>();
    collection.add(7);
    collection.add(8);
    collection.add(10);

    DoublyList doublyList = new DoublyList();
    doublyList.addArrayList(numbers);
    doublyList.print();
        System.out.println("---------");
    doublyList.addBeginningList(9);
    doublyList.print();
        System.out.println("---------");
        System.out.println("Первое значение = " + doublyList.extractionBeginningList());
        System.out.println("---------");
    doublyList.print();
        System.out.println("---------");
        System.out.println("Первое значение = " + doublyList.extractionDeleteList() + " удалено");
        System.out.println("---------");
    doublyList.print();
        System.out.println("---------");
    doublyList.addEndList(6);
    doublyList.print();
        System.out.println("---------");
        System.out.println("Последнее значение = " + doublyList.extractionEndList());
        System.out.println("---------");
    doublyList.print();
        System.out.println("---------");
        System.out.println("Последнее значение = " + doublyList.extractionEndDeleteList() + " удалено");
        System.out.println("---------");
    doublyList.print();
        System.out.println("---------");
        System.out.println(doublyList.setValueList(4));
        System.out.println("---------");
    doublyList.emptyList();
        System.out.println("---------");
        doublyList.addCollection(collection);
        doublyList.print();
        System.out.println("---------");
        doublyList.addEndCollection(collection);
        doublyList.print();
        System.out.println("---------");
        doublyList.printBack();
        System.out.println("---------");
    }
}
