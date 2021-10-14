package tsp.antcolony.isula;


import isula.aco.Ant;

public class AntColonyForSimpleTsp extends isula.aco.AntColony<String, SimpleTspEnvironment> {

    public AntColonyForSimpleTsp(int numberOfAnts) {
        super(numberOfAnts);
    }

    @Override
    protected Ant<String, SimpleTspEnvironment> createAnt(SimpleTspEnvironment environment) {
        return new AntForSimpleTsp(environment.getAllCities());
    }
}
