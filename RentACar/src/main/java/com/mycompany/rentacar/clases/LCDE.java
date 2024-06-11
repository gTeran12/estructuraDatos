/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentacar.clases;

/**
 *
 * @author guill
 */
public class LCDE<E> {

    private Node<E> head;
    private Node<E> tail;
    private Node<E> current;

    private static class Node<E> {

        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
        }
    }

    public LCDE() {
        head = null;
        tail = null;
        current = null;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
        if (current == null) {
            current = head;
        }
    }

    public E next() {
        if (current != null) {
            current = current.next;
            return current.data;
        }
        return null;
    }

    public E prev() {
        if (current != null) {
            current = current.prev;
            return current.data;
        }
        return null;
    }

    public E getCurrent() {
        return current != null ? current.data : null;
    }
}
