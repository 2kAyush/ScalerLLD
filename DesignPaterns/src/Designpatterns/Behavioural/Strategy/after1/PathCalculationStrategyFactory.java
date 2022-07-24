package Designpatterns.Behavioural.Strategy.after1;

public class PathCalculationStrategyFactory {
    PathCalculationStrategy getPathCalculationStrategyforMode(TransportMode mode){
        if(mode == TransportMode.WALK) {
            return new WalkPathCalculationStrategy();
        }
        else if(mode == TransportMode.CAR) {
            return new CarPathCalculationStrategy();
        }
        else if(mode == TransportMode.BIKE) {
            return new BikePathCalculationStrategy();
        }

        return null;
    }
}
