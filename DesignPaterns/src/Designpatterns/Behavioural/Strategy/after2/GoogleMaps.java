package Designpatterns.Behavioural.Strategy.after2;

import Designpatterns.Behavioural.Strategy.after1.PathCalculationStrategy;

public class GoogleMaps {
    private PathCalculationStrategyRegistry pathCalculationStrategyRegistry;
    public GoogleMaps(PathCalculationStrategyRegistry pathCalculationStrategyRegistry){
        this.pathCalculationStrategyRegistry = pathCalculationStrategyRegistry;
    }
    public void findPath(String from, String to, TransportMode mode) {
        PathCalculationStrategy pathCalculationStrategy = this.pathCalculationStrategyRegistry.get(mode);
        pathCalculationStrategy.calculatePath(from, to);
    }
}
