/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Collection;

/**
 *
 * @author USER
 */
public class DoublyList {
    private Node first;
    private Node last;

    //Массив
    public Integer[] array (Integer[] list){
        Integer[] result = new Integer[list.length];
        for (int i =0, j = result.length-1; i<list.length; i++,j--){
            result[j] = list[i];
        }
        return result;
    }

    //Добавление всех значений заданного массива в начало списка с сохранение порядка
    public void addArrayList (Integer [] variable){
        for (Integer i : array(variable)){
            addBeginningList(i);
        }
    }

    //Добавление всех значений заданного массива в конец списка с сохранение порядка
    public void addArrayListEnd (Integer [] variable){
        for (Integer i : variable){
            addEndList(i);
        }
    }

    // добавление значения в начало списка
    public void addBeginningList (Integer variable){
        Node newNode = new Node(variable);
        newNode.date = variable;
        if (first == null){
            first = newNode;
            last = newNode;
        }
        else {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }
    }
    //Извлечение значения из начала списка без его удаления из списка
    public int extractionBeginningList (){
        if (first != null)
            return first.date;
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Извлечение значения из начала списка с удалением из списка
    public int extractionDeleteList () {
        if (first != null && last.previous != null) {
            Integer firstDate = first.date;
            first = first.next;
            first.previous = null;
            return firstDate;
        } else if (first != null && first.next == null){
            Integer firstDate = first.date;
            first = first.next;
            return firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Добавление значения в конец списка
    public void addEndList (Integer variable){
        Node newNode = new Node(variable);
        if(first == null){
            first=newNode;
            return;
        }
        Node temp = first;
        Node temp1 = last;
        while (temp.next != null){
            temp = temp.next;
            temp1 = temp1.previous;
        }
        temp.next =newNode;
        temp1.previous =newNode;
    }

    //Извлечение значения из конца списка без его удаления
    public int extractionEndList (){
        if (first != null){
            Node temp = first;
            while (temp.next != null){
                temp = temp.next;}
            return temp.date;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    //Извлечение значения из конца списка с удалением
    public int extractionEndDeleteList (){
        if (first != null && last.previous != null) {
            Integer firstDate = last.date;
            last = last.previous;
            last.next = null;
            return firstDate;
        }
        else if(first != null && first.next == null){
            Integer firstDate = first.date;
            first = first.next;
            return firstDate;
        }
        else
            throw new IllegalArgumentException("Список пуст");
    }

    // Определение, содержит ли список заданное значение, или нет
    public boolean setValueList (Integer variable){
        Node temp = first;
        Boolean result = false;
        if(first == null)
            return false;
        else if (temp.next == null){
            return variable.equals(temp.date);
        }
        else
            while (temp.next != null){
                if(variable.equals(temp.date)){
                    result = true;
                    temp = temp.next;
                }
                else
                    temp = temp.next;
            }
        return  result;
    }

    // Определение, является ли список пустым, или нет
    public boolean emptyList (){
        if (first == null)
            System.out.println("Список пуст");
        else
            System.out.println("Список не пустой");
        return first == null;

    }



    // Печать всех значений списка в прямом порядке
    public void print() {
        if (first == null) return;
        Node temp = first;
        System.out.println(temp.date);
        while (temp.next != null){
            temp = temp.next;
            System.out.println(temp.date);
        }
    }
    // Печать всех значений списка в обратном порядке
    public void printBack (){
        if (first == null) return;
        Node temp = last;
        if(temp.previous == null){
            System.out.println(temp.date);
        }else {
            while (temp.previous != null){
                System.out.println(temp.date);
                temp = temp.previous;
                if(temp.previous == null){
                    System.out.println(temp.date);
                }
            }
        }
    }

    //Добавление всех значений заданной коллекции в начало списка с сохранением порядка

    public void addCollection (Collection<Integer> collection){
        Integer[] temp = collection.toArray(new Integer[0]);
        addArrayList(temp);
    }

    // Добавление всех значений заданной коллекции в конец списка с сохранением порядка
    public void addEndCollection (Collection<Integer> collection){
        Integer[] temp = collection.toArray(new Integer[0]);
        addArrayListEnd(temp);
    }

    //Возвращающий количество элементов списка.
    public int amount() {
        Node temp = first;
        if (first == null) {
            return 0;
        } else if (temp.next == null) {
            return 1;
        } else {
            int amo = 0;
            while (temp.next != null) {
                temp = temp.next;
                amo++;
                if (temp.next == null) {
                    amo++; }
            }
            return amo;
        }
    }
    //Удаление списка
    public void deleteList() {
        if (first != null) {
            first = null;
            last = null;  }
    }

    // Поглощение списка другим списком с добавлением значений второго в начало первого списка, после поглощения второй список должен очищаться

    public void mergerListBeginning(DoublyList mergerList){
        if (mergerList.first != null){
            Integer[] temp = new Integer[mergerList.amount()];
            Node temp1 = mergerList.first;
            temp[0] = temp1.date;
            int i =1;
            while (temp1.next != mergerList.last){
                temp[i] = temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.last)
                    temp[temp.length - 1] = mergerList.last.date;
            }
            addArrayList(temp);
            mergerList.deleteList();
        }
    }

    // Поглощение списка другим списком с добавлением значений второго в конец первого списка, после поглощения второй список должен очищаться

    public void mergerListEnd(DoublyList mergerList){
        if (mergerList.first != null){
            Integer[] temp = new Integer[mergerList.amount()];
            Node temp1 = mergerList.first;
            temp[0] = temp1.date;
            int i =1;
            while (temp1.next != mergerList.last){
                temp[i] = temp1.next.date;
                temp1 = temp1.next;
                i++;
                if (temp1.next == mergerList.last)
                    temp[temp.length - 1] = mergerList.last.date;
            }
            addArrayListEnd(temp);
            mergerList.deleteList();
        }
    }

    private class Node {
        Integer date;
        Node next;
        Node previous;

        Node(Integer variable){
            date = variable;
        }

    }
}
