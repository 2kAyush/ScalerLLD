package Solid;

import Solid.Behaviours.PFly;

public class Main {
    public static void main(String args[]) {
        System.out.println("Started");
        Pigeon pigeon = new Pigeon(2, "Pehla");
        Pigeon pigeon1 = new Pigeon(new PFly());
        Penguin penguin = new Penguin(3, "Ja na");
        Ostrich ostrich = new Ostrich(3, "Ja na");
        Crow crow = new Crow(3, "Ja na");
        Sparrow sparrow = new Sparrow(3, "Ja na");
//        pigeon.fly();
        pigeon1.fly();
//        crow.fly();
//        sparrow.fly();
//        penguin.eat();
//        ostrich.eat();
    }
}
