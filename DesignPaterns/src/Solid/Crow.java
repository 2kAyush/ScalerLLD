package Solid;

import Solid.interfaces.flyable;
import Solid.interfaces.FlyBehaviour;
import Solid.Behaviours.CSFly;
public class Crow extends Bird implements flyable{
    Crow(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public void fly() {
//        System.out.println("Pigeon is flying");
//        System.out.println(this.age);
//        System.out.println(this.name);
        System.out.println("inside Crow");
        FlyBehaviour fb = new CSFly();
        fb.makefly();
    }
    public void eat() {
        System.out.println("crow eating");
    }
}
