package Solid;


public class Ostrich extends Bird{
    Ostrich(int age, String name){
        this.age = age;
        this.name = name;
    }
    public void eat() {
        System.out.println("Ostrich's name: " + this.name + this.age);
        System.out.println("Ostrich eating");
    }
}
