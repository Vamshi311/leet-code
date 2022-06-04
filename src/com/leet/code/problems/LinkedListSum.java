package com.leet.code.problems;

import com.leet.code.model.Node;

public class LinkedListSum {

    public static void main(String[] args) {

        Node l1 = new Node(2);
        Node l2 = new Node(4);
        Node l3 = new Node(3);
        //Node l4 = new Node(5);
        l1.setNext(l2);
        l2.setNext(l3);
        //l3.setNext(l4);

        Node r1 = new Node(5);
        Node r2 = new Node(6);
        Node r3 = new Node(9);
        Node r4 = new Node(5);
        Node r5 = new Node(8);
        r1.setNext(r2);
        r2.setNext(r3);
        r3.setNext(r4);
        r4.setNext(r5);

        LinkedListSum linkedListSum = new LinkedListSum();
        Node result = linkedListSum.sum(l1, r1);
        print(result);
    }

    private static void print(Node result) {
        while(result != null) {
            System.out.print(result.getValue() + " -> ");
            result = result.getNext();
        }
    }

    public Node sum(Node l, Node r) {

        Node current = null;
        Node first = null;
        int carry = 0;
        while(l != null && r != null) {

            int sum = l.getValue() + r.getValue() + carry;
            int value = sum%10;
            carry = sum/10;

            Node node = new Node();
            node.setValue(value);

            if (first == null) {
                first = node;
                current = node;
            } else {
                current.setNext(node);
                current = node;
            }

            l = l.getNext();
            r = r.getNext();
        }

        while (l != null) {

            Node node = new Node();
            int sum = l.getValue() + carry;
            int value = sum%10;
            node.setValue(value);
            current.setNext(node);
            current = node;

            carry = sum/10;
            l = l.getNext();
        }

        while(r!=null) {
            Node node = new Node();
            int sum = r.getValue() + carry;
            int value = sum%10;
            node.setValue(value);
            current.setNext(node);
            current = node;

            carry = sum/10;
            r = r.getNext();
        }

        if (carry != 0) {
            Node node = new Node();
            node.setValue(carry);
            current.setNext(node);
        }
        return first;
    }
}
