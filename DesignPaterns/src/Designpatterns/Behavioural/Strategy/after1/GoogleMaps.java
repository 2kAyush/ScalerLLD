package Designpatterns.Behavioural.Strategy.after1;

public class GoogleMaps {
    private PathCalculationStrategyFactory pathCalculationStrategyFactory = new PathCalculationStrategyFactory();
    public void findPath(String from, String to, TransportMode mode) {
        PathCalculationStrategy pathCalculationStrategy = pathCalculationStrategyFactory.getPathCalculationStrategyforMode(mode);
        pathCalculationStrategy.calculatePath(from, to);
    }

}
