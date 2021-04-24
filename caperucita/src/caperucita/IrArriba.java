package caperucita;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrArriba extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        EstadoAgenteCaperucita estadoCaperucita = (EstadoAgenteCaperucita) s;

        estadoCaperucita.increaseVisitedCellsCount();

        int row = estadoCaperucita.getRowPosition();
        int col = estadoCaperucita.getColumnPosition();

        if (row == 0) {
            row = 3;
        } else {
            row = row - 1;
        }

        estadoCaperucita.setRowPosition(row);

        if (estadoCaperucita.getWorldPosition(row, col) !=
                PercepcionCaperucita.EMPTY_PERCEPTION) {

        	estadoCaperucita.setWorldPosition(row, col,
                    PercepcionCaperucita.EMPTY_PERCEPTION);

            return estadoCaperucita;
        }

        return null;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        EstadoAmbienteCaperucita environmentState = (EstadoAmbienteCaperucita) est;
        EstadoAgenteCaperucita pacmanState = ((EstadoAgenteCaperucita) ast);

        pacmanState.increaseVisitedCellsCount();

        int row = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        // Check the limits of the world
        if (row == 0) {
            row = 3;
        } else {
            row = row - 1;
        }

        pacmanState.setRowPosition(row);

        environmentState.setPosicionCaperucita(new int[] {row, col});
        
        return environmentState;
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }

    @Override
    public String toString() {
        return "GoUp";
    }
}