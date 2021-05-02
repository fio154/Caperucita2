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

        //System.out.println("CAPERUCITA: " + row + ", " + col);

        boolean avanza = false;

        for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS-1); i++){
            if (estadoCaperucita.getBosquePosition(i+1, col)==PercepcionCaperucita.OBSTACULO_PERCEPTION && avanza) {
                return estadoCaperucita;
            }else if (estadoCaperucita.getBosquePosition(i+1, col)==PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                return null;
            }else if(estadoCaperucita.getBosquePosition(i+1, col) == PercepcionCaperucita.FLORES_PERCEPTION){
                estadoCaperucita.setRowPosition(i+1);
                return estadoCaperucita;
            }else estadoCaperucita.setRowPosition(i+1);

            avanza = true;
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

        //System.out.println("CAPERUCITA-ambiente: " + row + ", " + col);

        boolean avanza = false;

        for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS-1); i++){
            environmentState.setPosicionCaperucita(new int[] {i, col});

            if (environmentState.getMapa()[i+1][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION && avanza) {
                return environmentState;
            }else if (environmentState.getMapa()[i+1][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                return null;
            }else if(environmentState.getMapa()[i+1][col] == PercepcionCaperucita.FLORES_PERCEPTION){
                environmentState.setPosicionCaperucita(new int[] {i+1, col});
                return environmentState;
            }else environmentState.setPosicionCaperucita(new int[] {i+1, col});

            avanza = true;
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
