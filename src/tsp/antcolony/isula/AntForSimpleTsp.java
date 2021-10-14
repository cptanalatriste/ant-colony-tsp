package tsp.antcolony.isula;

import tsp.TravellingHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AntForSimpleTsp extends isula.aco.Ant<String, SimpleTspEnvironment> {

    private final List<String> citiesToVisit;
    private String initialCity;
    private final Random random = new Random();

    public AntForSimpleTsp(List<String> citiesToVisit) {
        super();
        this.citiesToVisit = citiesToVisit;
        this.setSolution(new ArrayList<>());
    }

    @Override
    public void clear() {
        super.clear();

        int selectedIndex = random.nextInt(this.citiesToVisit.size());
        this.initialCity = citiesToVisit.get(selectedIndex);
    }

    @Override
    public boolean isSolutionReady(SimpleTspEnvironment simpleTspEnvironment) {
        return getCurrentIndex() == this.citiesToVisit.size();
    }

    @Override
    public double getSolutionCost(SimpleTspEnvironment simpleTspEnvironment, List<String> solution) {
        return TravellingHelper.calculateDistance(solution, simpleTspEnvironment.getDistanceMap());
    }

    @Override
    public Double getHeuristicValue(String candidateCity, Integer positionInSolution, SimpleTspEnvironment simpleTspEnvironment) {
        String lastCity = this.initialCity;
        if (getCurrentIndex() > 0) {
            lastCity = this.getSolution().get(getCurrentIndex() - 1);
        }

        Integer distance = simpleTspEnvironment.getDistanceMap().get(lastCity).get(candidateCity);
        return 1 / distance.doubleValue();
    }

    @Override
    public List<String> getNeighbourhood(SimpleTspEnvironment simpleTspEnvironment) {

        return this.citiesToVisit.stream()
                .filter(city -> !this.isNodeVisited(city))
                .collect(Collectors.toList());
    }

    @Override
    public Double getPheromoneTrailValue(String city, Integer cityIndex, SimpleTspEnvironment environment) {

        String lastCity = this.initialCity;
        if (getCurrentIndex() > 0) {
            lastCity = this.getSolution().get(getCurrentIndex() - 1);
        }

        return environment.getPheromoneTrailValue(lastCity, city);
    }

    @Override
    public void setPheromoneTrailValue(String city, Integer cityIndex, SimpleTspEnvironment environment,
                                       Double pheromoneValue) {

        String lastCity = this.initialCity;
        if (getCurrentIndex() > 0) {
            lastCity = this.getSolution().get(getCurrentIndex() - 1);
        }

        environment.setPheromoneTrailValue(lastCity, city, pheromoneValue);
    }
}
