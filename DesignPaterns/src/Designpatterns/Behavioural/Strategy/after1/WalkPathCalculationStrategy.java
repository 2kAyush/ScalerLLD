package Designpatterns.Behavioural.Strategy.after1;

public class WalkPathCalculationStrategy implements PathCalculationStrategy{
    public void calculatePath(String from, String to){
        System.out.println("Walk route");
    }
}
