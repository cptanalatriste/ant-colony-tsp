package tsp;

import java.util.List;
import java.util.Map;

public class TravellingHelper {

    public static Integer calculateDistance(List<String> route, Map<String, Map<String, Integer>> distanceMap) {

        int totalDistance = 0;
        for (int currentIndex = 0; currentIndex < route.size() - 1; currentIndex += 1) {
            int nextIndex = currentIndex + 1;
            String currentCity = route.get(currentIndex);
            String nextCity = route.get(nextIndex);

            int currentDistance = distanceMap.get(currentCity).get(nextCity);
            totalDistance += currentDistance;
        }

        String routeEnd = route.get(route.size() - 1);
        String routeStart = route.get(0);
        int backHomeDistance = distanceMap.get(routeEnd).get(routeStart);

        return totalDistance + backHomeDistance;
    }

    public static Map<String, Map<String, Integer>> getVerySmallProblem() {
        return Map.of(
                "Buenos Aires", Map.of("Caracas", 5114,
                        "Denver", 9555,
                        "Edmonton", 11139,
                        "Houston", 8150),
                "Caracas", Map.of("Buenos Aires", 5114,
                        "Denver", 4996,
                        "Edmonton", 6295,
                        "Houston", 3633),
                "Denver", Map.of("Buenos Aires", 9555,
                        "Caracas", 4996,
                        "Edmonton", 1642,
                        "Houston", 1408),
                "Edmonton", Map.of("Buenos Aires", 11139,
                        "Caracas", 6295,
                        "Denver", 1642,
                        "Houston", 3009),
                "Houston", Map.of("Buenos Aires", 8150,
                        "Caracas", 3633,
                        "Denver", 1408,
                        "Edmonton", 3009));
    }

    public static Map<String, Map<String, Integer>> getSmallProblem() {
        return Map.of(
                "Buenos Aires", Map.of("Caracas", 5114,
                        "Denver", 9555,
                        "Edmonton", 11139,
                        "Houston", 8150,
                        "Lima", 11139,
                        "Los Angeles", 9865,
                        "Mexico City", 7400,
                        "Montreal", 9047,
                        "New York", 8536),
                "Caracas", Map.of("Buenos Aires", 5114,
                        "Denver", 4996,
                        "Edmonton", 6295,
                        "Houston", 3633,
                        "Lima", 2744,
                        "Los Angeles", 5832,
                        "Mexico City", 3585,
                        "Montreal", 3936,
                        "New York", 3422),
                "Denver", Map.of("Buenos Aires", 9555,
                        "Caracas", 4996,
                        "Edmonton", 1642,
                        "Houston", 1408,
                        "Lima", 6446,
                        "Los Angeles", 1386,
                        "Mexico City", 2335,
                        "Montreal", 2604,
                        "New York", 2593),
                "Edmonton", Map.of("Buenos Aires", 11139,
                        "Caracas", 6295,
                        "Denver", 1642,
                        "Houston", 3009,
                        "Lima", 8116,
                        "Los Angeles", 2189,
                        "Mexico City", 3972,
                        "Montreal", 2982,
                        "New York", 3261),
                "Houston", Map.of("Buenos Aires", 8150,
                        "Caracas", 3633,
                        "Denver", 1408,
                        "Edmonton", 3009,
                        "Lima", 5108,
                        "Los Angeles", 2223,
                        "Mexico City", 1211,
                        "Montreal", 2585,
                        "New York", 2263),
                "Lima", Map.of("Buenos Aires", 3141,
                        "Caracas", 2744,
                        "Denver", 6446,
                        "Edmonton", 8116,
                        "Houston", 5108,
                        "Los Angeles", 6735,
                        "Mexico City", 4260,
                        "Montreal", 6416,
                        "New York", 5903),
                "Los Angeles", Map.of("Buenos Aires", 9865,
                        "Caracas", 5823,
                        "Denver", 1386,
                        "Edmonton", 2189,
                        "Houston", 2223,
                        "Lima", 6735,
                        "Mexico City", 2498,
                        "Montreal", 3991,
                        "New York", 3959),
                "Mexico City", Map.of("Buenos Aires", 7400,
                        "Caracas", 3585,
                        "Denver", 2335,
                        "Edmonton", 3972,
                        "Houston", 1211,
                        "Lima", 4260,
                        "Los Angeles", 2498,
                        "Montreal", 3733,
                        "New York", 3363),
                "Montreal", Map.of("Buenos Aires", 9047,
                        "Caracas", 3936,
                        "Denver", 2604,
                        "Edmonton", 2982,
                        "Houston", 2585,
                        "Lima", 6416,
                        "Los Angeles", 3991,
                        "Mexico City", 3733,
                        "New York", 534),
                "New York", Map.of("Buenos Aires", 8536,
                        "Caracas", 3422,
                        "Denver", 2593,
                        "Edmonton", 3261,
                        "Houston", 2263,
                        "Lima", 5903,
                        "Los Angeles", 3959,
                        "Mexico City", 3363,
                        "Montreal", 534));
    }
}