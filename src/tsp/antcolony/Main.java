package tsp.antcolony;

import tsp.TravellingHelper;

import javax.naming.ConfigurationException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Main {

    private static void solveTsp(Map<String, Map<String, Integer>> distanceMap) throws ConfigurationException {

        Instant start = Instant.now();
        AntColonyTsp solver = new AntColonyTsp();
        List<String> optimalRoute = solver.findOptimalRoute(distanceMap);
        Instant end = Instant.now();
        System.out.println("Optimal route: " + optimalRoute);
        System.out.println("Optimal distance (kilometers): " + TravellingHelper.calculateDistance(optimalRoute, distanceMap));
        System.out.println("Execution time (milliSeconds): " + Duration.between(start, end).toMillis());
    }

    public static void main(String[] args) throws ConfigurationException {
        System.out.println("Solving a very small problem ");
        solveTsp(TravellingHelper.getVerySmallProblem());

        System.out.println("Solving a small problem ");
        solveTsp(TravellingHelper.getSmallProblem());
    }
}