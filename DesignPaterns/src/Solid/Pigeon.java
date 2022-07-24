package Solid;

import Solid.interfaces.flyable;
import Solid.interfaces.FlyBehaviour;

public class Pigeon extends Bird implements flyable {
    public FlyBehaviour fb;
    Pigeon(int age, String name){
        this.age = age;
        this.name = name;
    }

    Pigeon(FlyBehaviour fb) {
        this.fb = fb;
    }
    public void fly() {
//        System.out.println("Pigeon is flying");
//        System.out.println(this.age);
//        System.out.println(this.name);
        System.out.println("inside Pigeon");
//        FlyBehaviour fb = new PFly();
        this.fb.makefly();
    }

    @Override
    public void eat() {
        System.out.println("pigeon eating");
    }
}
