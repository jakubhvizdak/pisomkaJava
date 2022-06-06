package com.company;


public class Main {

    public static void main(String[] args) {
        Pocitac pc1 = new Pocitac("Jakub", "123", "nazdar");
        System.out.println(pc1.getTime());
        Pocitac pc2 = new Pocitac("Tibor", "heslo123", "nevem");
        System.out.println(pc2.getTime());
    }
}
