package com.company;

import java.util.Arrays;
/**
 * Created by jwang on 7/5/16.
 */
public class IntSet {

    private Node head;
    private int size;


    public IntSet(Node head, int size){
        this.head = head;
        this.size = size;
    }


    public boolean contain(int value){
        Node cursor = head;

        while(cursor != null){
            if(value == cursor.getValue()){
                return true;
            } else {
                cursor = cursor.getNext();
            }
        } return false;
    }

    public void remove(int value){

        if(contain(value)){
            if(head.getValue() == value){
                head = head.getNext();
                size--;
                return;
            }
            Node cursor = head.getNext();
            Node previous = head;

            while(cursor.getValue() != value){
                previous = cursor;
                cursor = cursor.getNext();
            }
            previous.setNext(cursor.getNext());
            size--;

        }
    }

    public void addElement(int value){

        Node cursor = head;

        if(cursor == null){

            head = new Node(value, null);
            size++;
        }
        if(!contain(value)){

            Node newNode = new Node(value, null);

            //find the last node
            while(cursor.getNext() != null){
                cursor = cursor.getNext();
            }

            cursor.setNext(newNode);
            size++;
        }
    }

    public int size(){
        return size;
    }

    public boolean subsetOf(IntSet givenSet){

        Node a = head;
        Node b = givenSet.head;
        IntSet c = this;

        if(size < givenSet.size){
            return false;
        } else {
            while(b != null){
                while(a != null){
                    if(!c.contain(a.getValue())){
                        return false;
                    }
                    a = a.getNext();
                }
                b = b.getNext();
                a = head;
            }
            return true;
        }
    }

    public boolean isEqual(IntSet givenSet){

        if(size != givenSet.size){
            return false;
        } else {
            int[] arrayA = new int[size];
            int[] arrayB = new int[givenSet.size];
            Node a = head;
            Node b = givenSet.head;

            for(int i = 0; i < size; i++){
                arrayA[i] = a.getValue();
                a = a.getNext();
                arrayB[i] = b.getValue();
                b = b.getNext();
            }

            Arrays.sort(arrayA);
            Arrays.sort(arrayB);

            for(int i = 0; i < size; i++){
                if(arrayA[i] != arrayB[i]){
                    return false;
                }
            }
            return true;
        }
    }

    public IntSet union(IntSet givenSet){

        Node a = head;
        Node b = givenSet.head;
        IntSet c = new IntSet(null, 0);

        while(a != null){
            c.addElement(a.getValue());
            a = a.getNext();
        }

        while(b != null){
            c.addElement(b.getValue());
            b = b.getNext();
        }

        return c;
    }

    public IntSet intersection(IntSet givenSet){

        Node a = head;
        Node b = givenSet.head;
        IntSet c = new IntSet(null, 0);

        int[] arrayA = new int[size];
        int[] arrayB = new int[givenSet.size];

        for(int i = 0; i < size; i++){
            arrayA[i] = a.getValue();
            a = a.getNext();
        }

        for (int j = 0; j < givenSet.size; j++){
            arrayB[j] = b.getValue();
            b = b.getNext();
        }

        for (int i = 0; i < arrayA.length; i++){
            for(int j = 0; j < arrayB.length; j++){
                if(arrayA[i] == arrayB[j]){
                    c.addElement(arrayA[i]);
                }
            }
        }
        return c;

    }

    public IntSet complement(IntSet givenSet){

        Node a = head;
        Node b = givenSet.head;
        IntSet c = this;

        while(a != null){
            while(b != null){
                if(b.getValue() == a.getValue()){
                    c.remove(b.getValue());
                }
                b = b.getNext();
            }
            a = a.getNext();
            b = givenSet.head;
        }
        return c;
    }

    public String toString(){

        Node cursor = head;
        String result = "[";

        while(cursor != null){
            if(cursor.getNext() == null){
                result += cursor.getValue();
            } else {
                result += cursor.getValue() + ",";
            }

            cursor = cursor.getNext();

        }
        result += "]";
        return result;
    }
}
