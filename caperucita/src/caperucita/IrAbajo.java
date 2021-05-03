package caperucita.src.caperucita;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrAbajo extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        EstadoAgenteCaperucita estadoCaperucita = (EstadoAgenteCaperucita) s;

        estadoCaperucita.increaseVisitedCellsCount();

        int row = estadoCaperucita.getRowPosition();
        int col = estadoCaperucita.getColumnPosition();

        if (estadoCaperucita.getBosquePosition(row+1, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION){
            return null;
        }

        for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS-1); i++){
            if (estadoCaperucita.getBosquePosition(i+1, col)==PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                estadoCaperucita.setRowPosition(i);
                return estadoCaperucita;
            }

            if(estadoCaperucita.getBosquePosition(i+1, col) == PercepcionCaperucita.FLORES_PERCEPTION){
                estadoCaperucita.setRowPosition(i+1);
                return estadoCaperucita;
            }
        }

        //System.out.println("abajo: " + row + ", " + col);

        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        EstadoAmbienteCaperucita environmentState = (EstadoAmbienteCaperucita) est;
        EstadoAgenteCaperucita estadoCaperucita = ((EstadoAgenteCaperucita) ast);

        estadoCaperucita.increaseVisitedCellsCount();

        int row = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        if (estadoCaperucita.getBosquePosition(row+1, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION){
            return null;
        }

        for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS-1); i++){

            if(environmentState.getMapa()[i][col] == PercepcionCaperucita.DULCE_PERCEPTION){
                estadoCaperucita.setDulces(estadoCaperucita.getDulces()+1);
                environmentState.setMapa(i, col, PercepcionCaperucita.EMPTY_PERCEPTION);
                estadoCaperucita.setBosquePosition(i, col, PercepcionCaperucita.EMPTY_PERCEPTION);
            }

            if(environmentState.getMapa()[i][col] == PercepcionCaperucita.LOBO_PERCEPTION){
                environmentState.reiniciarMapa(i, col, estadoCaperucita);
                return environmentState;
            }

            if (environmentState.getMapa()[i+1][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                estadoCaperucita.setRowPosition(i);
                environmentState.setPosicionCaperucita(new int[] {i, col});
                environmentState.cambiarPosicionLobo(i, col, estadoCaperucita);
                return environmentState;
            }

            if(environmentState.getMapa()[i+1][col] == PercepcionCaperucita.FLORES_PERCEPTION){
                estadoCaperucita.setRowPosition(i+1);
                environmentState.setPosicionCaperucita(new int[] {i+1, col});
                environmentState.cambiarPosicionLobo(i+1, col, estadoCaperucita);
                return environmentState;
            }


        }

        //System.out.println("abajoAmbiente: " + row + ", " + col);

        return environmentState;
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }
    @Override
    public String toString() {
        return "IrAbajo";
    }

}
