package com.company;

/**
 * Created by jwang on 7/5/16.
 */
public class Node {

    private int value;
    private Node next;

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        this.next = n;
    }



}
