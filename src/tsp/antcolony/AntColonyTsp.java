package tsp.antcolony;

import isula.aco.AcoProblemSolver;
import isula.aco.algorithms.antsystem.OfflinePheromoneUpdate;
import isula.aco.algorithms.antsystem.PerformEvaporation;
import isula.aco.algorithms.antsystem.RandomNodeSelection;
import isula.aco.algorithms.antsystem.StartPheromoneMatrix;
import tsp.antcolony.isula.AntColonyForSimpleTsp;
import tsp.antcolony.isula.SimpleTspConfiguration;
import tsp.antcolony.isula.SimpleTspEnvironment;

import javax.naming.ConfigurationException;
import java.util.List;
import java.util.Map;

public class AntColonyTsp {
    public List<String> findOptimalRoute(Map<String, Map<String, Integer>> distanceMap) throws ConfigurationException {

        SimpleTspEnvironment environment = new SimpleTspEnvironment(distanceMap);
        SimpleTspConfiguration configuration = new SimpleTspConfiguration(environment);
        AntColonyForSimpleTsp colony = new AntColonyForSimpleTsp(configuration.getNumberOfAnts());

        AcoProblemSolver<String, SimpleTspEnvironment> solver = new AcoProblemSolver<>();
        solver.initialize(environment, colony, configuration);
        solver.addDaemonActions(new StartPheromoneMatrix<>(), new PerformEvaporation<>());
        solver.addDaemonActions(new OfflinePheromoneUpdate<>());
        solver.getAntColony().addAntPolicies(new RandomNodeSelection<>());

        solver.solveProblem();

        return solver.getBestSolution();
    }
}
