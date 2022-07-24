package Designpatterns.Creational.Builder;

public class Main {
    public static void main(String[] args) {
        // this should be inside try catch block (because validation is throwing exception)
        Example obj = Example.getBuilder().setA(5).setB(6).setC(7).build();
        obj.printAll();
    }
}
