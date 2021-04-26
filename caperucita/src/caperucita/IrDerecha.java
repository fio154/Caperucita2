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

        if (col == (EstadoAmbienteCaperucita.CANT_COLUM-1)) {
            return null;
        } else {
            col = col + 1;

            for(int i=col; i<EstadoAmbienteCaperucita.CANT_COLUM; i++){
                estadoCaperucita.setColumnPosition(col);

                if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    col = col - 1;
                    estadoCaperucita.setColumnPosition(col);
                    return estadoCaperucita;
                }else{
                    return null;
                }
            }
        }

        System.out.println("derecha: " + row + ", " + col);
        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        EstadoAmbienteCaperucita environmentState = (EstadoAmbienteCaperucita) est;
        EstadoAgenteCaperucita estadoCaperucita = ((EstadoAgenteCaperucita) ast);

        estadoCaperucita.increaseVisitedCellsCount();

        int row = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        if (col == (EstadoAmbienteCaperucita.CANT_COLUM-1)) {
            return null;
        } else {
            col = col + 1;

            for(int i=col; i<EstadoAmbienteCaperucita.CANT_COLUM; i++){
                environmentState.setPosicionCaperucita(new int[] {row, col});

                if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    col = col - 1;
                    environmentState.setPosicionCaperucita(new int[] {row, col});
                    return environmentState;
                }else{
                    return null;
                }
            }
        }

        System.out.println("derechaAmbiente: " + row + ", " + col);

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
