package Solid;

public class Penguin extends Bird{
    Penguin(int age, String name){
        this.age = age;
        this.name = name;
    }
    public void eat() {
        System.out.println("Penguin's name: " + this.name + this.age);
        System.out.println("penguin eating");
    }
}
