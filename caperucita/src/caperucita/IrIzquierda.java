package caperucita.src.caperucita;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrIzquierda extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        EstadoAgenteCaperucita estadoCaperucita = (EstadoAgenteCaperucita) s;

        estadoCaperucita.increaseVisitedCellsCount();

        int row = estadoCaperucita.getRowPosition();
        int col = estadoCaperucita.getColumnPosition();

        if (col == 0) {
            return null;
        } else {
            col = col - 1;

            for(int i=col; i<EstadoAmbienteCaperucita.CANT_FILAS; i++){
                estadoCaperucita.setColumnPosition(i);

                if (estadoCaperucita.getBosquePosition(row, i) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    col = i + 1;
                    estadoCaperucita.setColumnPosition(col);
                    System.out.println("izquierda: " + row + ", " + col);
                    return estadoCaperucita;
                }else if(estadoCaperucita.getBosquePosition(row, i) == PercepcionCaperucita.FLORES_PERCEPTION){
                    System.out.println("izquierda: " + row + ", " + i);
                    return estadoCaperucita;
                }
            }
        }

        System.out.println("izquierda: " + row + ", " + col);

        return estadoCaperucita;
    }


    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        EstadoAmbienteCaperucita environmentState = (EstadoAmbienteCaperucita) est;
        EstadoAgenteCaperucita estadoCaperucita = ((EstadoAgenteCaperucita) ast);

        estadoCaperucita.increaseVisitedCellsCount();

        int row = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        if (col == 0) {
            return null;
        } else {
            col = col - 1;

            for(int i=col; i<EstadoAmbienteCaperucita.CANT_FILAS; i++){
                environmentState.setPosicionCaperucita(new int[] {row, i});

                if (estadoCaperucita.getBosquePosition(row, i) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    col = i + 1;
                    environmentState.setPosicionCaperucita(new int[] {row, col});
                    System.out.println("izquierdaAmbiente: " + row + ", " + col);
                    return environmentState;
                }else if(estadoCaperucita.getBosquePosition(row, i) == PercepcionCaperucita.FLORES_PERCEPTION){
                    System.out.println("izquierdaAmbiente: " + row + ", " + i);
                    return environmentState;
                }
            }
        }
        System.out.println("izquierdaAmbiente: " + row + ", " + col);

        return environmentState;
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }

    @Override
    public String toString() {
        return "IrIzquierda";
    }
}
