package com.company;

import java.util.Scanner;

public class TreeSet<T> {
    private Node rootNode;

    private IComparator<T> comparator;

    public TreeSet(IComparator<T> comparator) {
        this.rootNode = new Node();
        this.comparator = comparator;
    }

    public boolean add(T value) {
        try {
            this.rootNode.setValue(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(T value) {

        return false;
    }

    class Node {
        T value;
        Node leftNode;
        Node rightNode;

        public Node() { }

        public Node(T value) {
            this.setValue(value);
        }

        public void setValue(T value) {
            if (this.value == null) {
                this.value = value;
            } else {
                if (comparator.compare(this.value, value)) {
                    if (this.leftNode == null) {
                        this.leftNode = new Node(value);
                    } else {
                        this.leftNode.setValue(value);
                    }
                } else if (!comparator.compare(this.value, value)) {
                    if(this.rightNode == null) {
                        this.rightNode = new Node(value);
                    } else {
                        this.rightNode.setValue(value);
                    }
                }
            }
        }
    }
}
