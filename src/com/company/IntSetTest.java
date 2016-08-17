package com.company;

public class IntSetTest {

    public static void main(String[] args) {

	    // add a (head) node with value of 5
        //Case 1
        Node first = new Node(1, null);
        IntSet a = new IntSet(first, 1);
        a.addElement(2);
        a.addElement(3);

        Node n1 = new Node(2, null);
        IntSet b = new IntSet(n1, 1);
        b.addElement(1);
        b.addElement(3);

        System.out.println(b.intersection(a));
        System.out.println(b.union(a));

        //Case 2

        Node x = new Node(1, null);
        IntSet c = new IntSet(x, 1);

        Node y = new Node(1, null);
        IntSet d = new IntSet(y, 1);
        d.addElement(2);

        System.out.println(c.union(d));
        System.out.println(c.subsetOf(d));

        //Case 3

        Node n3 = new Node(1, null);
        IntSet g = new IntSet(n3, 1);
        g.addElement(2);
        g.addElement(3);

        Node n4 = new Node(1, null);
        IntSet h = new IntSet(n4, 1);
        h.addElement(2);
        h.addElement(3);
        h.addElement(4);

        System.out.println(g.subsetOf(h));

        //Case 4

        Node n5 = new Node(2, null);
        IntSet i = new IntSet(n5, 1);
        i.addElement(4);
        i.addElement(6);

        Node n6 = new Node(1, null);
        IntSet j = new IntSet(n6, 1);
        j.addElement(3);
        j.addElement(5);

        System.out.println(i.intersection(j));
        System.out.println(i.union(j));
        System.out.println(i.complement(j));

        //Case 5

        IntSet n = new IntSet(null, 0);

        Node n8 = new Node(1, null);
        IntSet m = new IntSet(n8, 1);
        m.addElement(3);
        m.addElement(5);

        System.out.println(n.union(m));
        System.out.println(n.intersection(m));

    }
}
