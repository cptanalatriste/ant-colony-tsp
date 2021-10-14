package tsp.antcolony.isula;

import isula.aco.algorithms.antsystem.AntSystemConfigurationProvider;

public record SimpleTspConfiguration(
        SimpleTspEnvironment environment) implements AntSystemConfigurationProvider {

    @Override
    public int getNumberOfAnts() {
        return environment.getAllCities().size() / 2;
    }

    @Override
    public double getEvaporationRatio() {
        return 0.4;
    }

    @Override
    public int getNumberOfIterations() {
        return 1000;
    }

    @Override
    public double getInitialPheromoneValue() {
        return 1;
    }

    @Override
    public double getHeuristicImportance() {
        return 7;
    }

    @Override
    public double getPheromoneImportance() {
        return 4;
    }

    @Override
    public double getPheromoneDepositFactor() {
        return 1;
    }
}