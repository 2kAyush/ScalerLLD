package Designpatterns.Behavioural.Strategy.after2;

import Designpatterns.Behavioural.Strategy.after1.BikePathCalculationStrategy;
import Designpatterns.Behavioural.Strategy.after1.CarPathCalculationStrategy;
import Designpatterns.Behavioural.Strategy.after1.WalkPathCalculationStrategy;

public class Main {
    public static void main(String[] args) {
        PathCalculationStrategyRegistry pathCalculationStrategyRegistry = new PathCalculationStrategyRegistry();
        pathCalculationStrategyRegistry.register(TransportMode.CAR, new CarPathCalculationStrategy());
        pathCalculationStrategyRegistry.register(TransportMode.WALK, new WalkPathCalculationStrategy());
        pathCalculationStrategyRegistry.register(TransportMode.BIKE, new BikePathCalculationStrategy());

        GoogleMaps googleMaps = new GoogleMaps(pathCalculationStrategyRegistry);
        googleMaps.findPath("lf", "ajdk", TransportMode.CAR);
    }
}
