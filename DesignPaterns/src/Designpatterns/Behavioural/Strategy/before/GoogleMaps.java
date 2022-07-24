package Designpatterns.Behavioural.Strategy.before;

public class GoogleMaps {
    public void findPath(String from, String to, TransportMode mode) {
        if(mode == TransportMode.BIKE){
            System.out.println("Bike path finding");
        }
        else if(mode == TransportMode.CAR){
            System.out.println("CAR path finding");
        }
        else if(mode == TransportMode.WALK){
            System.out.println("WALK path finding");
        }
    }

}
