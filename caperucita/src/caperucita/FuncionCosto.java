package caperucita;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class FuncionCosto implements IStepCostFunction {
    @Override
    public double calculateCost(NTree node) {
        return ((EstadoAgenteCaperucita) node.getAgentState()).getVisitedCellsCount();
    }
}