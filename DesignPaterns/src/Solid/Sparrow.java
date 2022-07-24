package Solid;

import Solid.Behaviours.CSFly;
import Solid.interfaces.flyable;
import Solid.interfaces.FlyBehaviour;

public class Sparrow extends Bird implements flyable{
    Sparrow(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public void fly() {
//        System.out.println("Pigeon is flying");
//        System.out.println(this.age);
//        System.out.println(this.name);
        System.out.println("inside Sparrow");
        FlyBehaviour fb = new CSFly();
        fb.makefly();
    }
    public void eat() {
        System.out.println("sparrow eating");
    }
}
