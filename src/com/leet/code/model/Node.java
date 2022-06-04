package com.leet.code.model;

public class Node {

    private Integer value;
    private Node next;

    public Node() {

    }

    public Node(Integer value) {
        this.value = value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}