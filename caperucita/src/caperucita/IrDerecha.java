package caperucita.src.caperucita;

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


        if (estadoCaperucita.getBosquePosition(row, col+1) == PercepcionCaperucita.OBSTACULO_PERCEPTION){
            return null;
        }

        for(int i=col; i<(EstadoAmbienteCaperucita.CANT_COLUM-1); i++){

            if (estadoCaperucita.getBosquePosition(row, i+1) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                estadoCaperucita.setColumnPosition(i);
                return estadoCaperucita;
            }

            if(estadoCaperucita.getBosquePosition(row, i+1) == PercepcionCaperucita.FLORES_PERCEPTION){
                estadoCaperucita.setColumnPosition(i+1);
                return estadoCaperucita;
            }

        }

        //System.out.println("derecha: " + row + ", " + col);
        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        EstadoAmbienteCaperucita environmentState = (EstadoAmbienteCaperucita) est;
        EstadoAgenteCaperucita estadoCaperucita = ((EstadoAgenteCaperucita) ast);

        estadoCaperucita.increaseVisitedCellsCount();

        int row = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        if (estadoCaperucita.getBosquePosition(row, col+1) == PercepcionCaperucita.OBSTACULO_PERCEPTION){
            return null;
        }

        for(int i=col; i<(EstadoAmbienteCaperucita.CANT_COLUM-1); i++){

            if(estadoCaperucita.getBosquePosition(row, i) == PercepcionCaperucita.DULCE_PERCEPTION){
                estadoCaperucita.setDulces(estadoCaperucita.getDulces()+1);
                environmentState.setMapa(row, i, PercepcionCaperucita.EMPTY_PERCEPTION);
                estadoCaperucita.setBosquePosition(row, i, PercepcionCaperucita.EMPTY_PERCEPTION);
            }

            if (environmentState.getMapa()[row][i+1] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                estadoCaperucita.setColumnPosition(i);
                environmentState.setPosicionCaperucita(new int[] {row, i});
                return environmentState;
            }

            if(environmentState.getMapa()[row][i+1] == PercepcionCaperucita.FLORES_PERCEPTION){
                estadoCaperucita.setColumnPosition(i+1);
                environmentState.setPosicionCaperucita(new int[] {row, i+1});
                return environmentState;
            }

        }

        //System.out.println("derechaAmbiente: " + row + ", " + col);

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
