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

        boolean avanza = false;

        for(int i=col; i<(EstadoAmbienteCaperucita.CANT_COLUM-1); i++){
            if (estadoCaperucita.getBosquePosition(row, i+1) == PercepcionCaperucita.OBSTACULO_PERCEPTION && avanza) {
                return estadoCaperucita;
            }else if (estadoCaperucita.getBosquePosition(row, i+1) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                return null;
            }else if(estadoCaperucita.getBosquePosition(row, i+1) == PercepcionCaperucita.FLORES_PERCEPTION){
                estadoCaperucita.setColumnPosition(i+1);
                return estadoCaperucita;
            }else estadoCaperucita.setColumnPosition(i+1);

            avanza = true;
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

        boolean avanza = false;

        for(int i=col; i<(EstadoAmbienteCaperucita.CANT_COLUM-1); i++){
            if (environmentState.getMapa()[row][i+1] == PercepcionCaperucita.OBSTACULO_PERCEPTION && avanza) {
                return environmentState;
            }else if (environmentState.getMapa()[row][i+1] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                return null;
            }else if(environmentState.getMapa()[row][i+1] == PercepcionCaperucita.FLORES_PERCEPTION){
                environmentState.setPosicionCaperucita(new int[] {row, i+1});
                return environmentState;
            }else environmentState.setPosicionCaperucita(new int[] {row, i+1});

            avanza = true;
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
