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
    public List<String> findOptimalRoute(Map<String, Map<String, Integer>> distanceMap)
            throws ConfigurationException {

        //The environment contains the distance information and the pheromone values.
        SimpleTspEnvironment environment = new SimpleTspEnvironment(distanceMap);
        //This object contains the algorithm parameters (number of ants, initial pheromone, etc.).
        SimpleTspConfiguration configuration = new SimpleTspConfiguration(environment);
        //The colony administers the ants. It creates them and makes them build solutions.
        AntColonyForSimpleTsp colony = new AntColonyForSimpleTsp(
                configuration.getNumberOfAnts());

        //The solver orchestrates the whole process.
        AcoProblemSolver<String, SimpleTspEnvironment> solver = new AcoProblemSolver<>();
        solver.initialize(environment, colony, configuration);
        //Daemon actions are external events, not associated with the ants. We are adding pheromone
        // initialization, evaporation, and updating pheromones at the end of solution building.
        solver.addDaemonActions(new StartPheromoneMatrix<>(), new PerformEvaporation<>());
        solver.addDaemonActions(new OfflinePheromoneUpdate<>());
        //This ant policy contains the rules for adding new components to the ant's solution.
        solver.getAntColony().addAntPolicies(new RandomNodeSelection<>());

        solver.solveProblem();

        return solver.getBestSolution();
    }
}
