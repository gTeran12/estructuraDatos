package com.mycompany.rentacar.clases;

/**
 *
 * @author Hackzll
 */
public class LinkedList<T> {

    private Node head;
    private Node tail;
    private int length;

    class Node {

        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    public LinkedList(T value) {
        //Create new node
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;

    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void append(T value) {
        //Create new node and add to the end of the list
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;

    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;

    }

    //Metodo para agregar un nodo al inicio de una LL 
    public void prepend(T value) {
        //Create new node and add to the beginning of the list
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;

    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    
    public boolean set(int index, T value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, T value) {
        //Create new node and add to the list at the specified index
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }
    
}

