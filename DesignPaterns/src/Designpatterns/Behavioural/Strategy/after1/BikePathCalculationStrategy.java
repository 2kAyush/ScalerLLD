package Designpatterns.Behavioural.Strategy.after1;

public class BikePathCalculationStrategy implements PathCalculationStrategy{
    public void calculatePath(String from, String to){
        System.out.println("Bike route");
    }
}
