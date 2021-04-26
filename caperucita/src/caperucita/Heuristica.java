package caperucita.src.caperucita;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristica implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoAgenteCaperucita estadoCaperucita = (EstadoAgenteCaperucita) node.getAgentState();

        return (estadoCaperucita.getCeldasNoConocidas()*10 +
                estadoCaperucita.getDulcesRestantes()*50);
    }
}