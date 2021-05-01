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

        if (row >= (EstadoAmbienteCaperucita.CANT_FILAS-1)) {
            return null;
        } else {
            row = row + 1;

            for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS); i++){
                estadoCaperucita.setRowPosition(i);

                if (estadoCaperucita.getBosquePosition(i, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    row = i - 1;
                    estadoCaperucita.setRowPosition(row);
                    //System.out.println("abajo: " + row + ", " + col);
                    return null;
                }else if(estadoCaperucita.getBosquePosition(i, col) == PercepcionCaperucita.FLORES_PERCEPTION){
                    //System.out.println("abajo: " + i + ", " + col);
                    return estadoCaperucita;
                }
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

        //System.out.println("CAPERUCITA-ambiente: " + row + ", " + col);

        if (row >= (EstadoAmbienteCaperucita.CANT_FILAS-1)) {
            return null;
        } else {
            row = row + 1;

            for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS-1); i++){
                environmentState.setPosicionCaperucita(new int[] {i, col});

                if (estadoCaperucita.getBosquePosition(i, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    row = i - 1;
                    environmentState.setPosicionCaperucita(new int[] {row, col});
                    //System.out.println("abajoAmbiente: " + row + ", " + col);
                    return null;
                }else if(estadoCaperucita.getBosquePosition(i, col) == PercepcionCaperucita.FLORES_PERCEPTION){
                    //System.out.println("abajoAmbiente: " + i + ", " + col);
                    return environmentState;
                }
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
