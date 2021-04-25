package caperucita;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrDerecha extends SearchAction {
	
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        EstadoAgenteCaperucita estadoCaperucita = (EstadoAgenteCaperucita) s;

        estadoCaperucita.increaseVisitedCellsCount();

        int row = estadoCaperucita.getRowPosition();
        int col = estadoCaperucita.getColumnPosition();

        if (col < estadoCaperucita.getBosque()[row].length) {
            col = col + 1;
        }

        estadoCaperucita.setColumnPosition(col);

        if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
            estadoCaperucita.setBosquePosition(row, col, PercepcionCaperucita.OBSTACULO_PERCEPTION);
        }
        
        if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.EMPTY_PERCEPTION) {
            estadoCaperucita.setBosquePosition(row, col, PercepcionCaperucita.EMPTY_PERCEPTION);
        }
        
        if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.DULCE_PERCEPTION) {
            estadoCaperucita.setBosquePosition(row, col, PercepcionCaperucita.DULCE_PERCEPTION);
        }
        
        if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.LOBO_PERCEPTION) {
            estadoCaperucita.setBosquePosition(row, col, PercepcionCaperucita.LOBO_PERCEPTION);
        }

        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        EstadoAmbienteCaperucita environmentState = (EstadoAmbienteCaperucita) est;
        EstadoAgenteCaperucita estadoCaperucita = ((EstadoAgenteCaperucita) ast);

        estadoCaperucita.increaseVisitedCellsCount();

        int row = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        if (col < environmentState.getBosque()[row].length) {
            col = col + 1;
        }

        estadoCaperucita.setColumnPosition(col);

        environmentState.setPosicionCaperucita(new int[] {row, col});

        return environmentState;
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }

    @Override
    public String toString() {
        return "IrDerecha";
    }
}
