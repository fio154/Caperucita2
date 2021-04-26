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

        System.out.println("CAPERUCITA: " + row + ", " + col);

        if (row == (EstadoAmbienteCaperucita.CANT_FILAS-1)) {
            return null;
        } else {
            row = row + 1;

            for(int i=row; i<EstadoAmbienteCaperucita.CANT_FILAS; i++){
                estadoCaperucita.setRowPosition(row);

                if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    row = row - 1;
                    estadoCaperucita.setRowPosition(row);
                    return estadoCaperucita;
                }else{
                    return null;
                }
            }
        }

        System.out.println("abajo: " + row + ", " + col);

        return estadoCaperucita;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        EstadoAmbienteCaperucita environmentState = (EstadoAmbienteCaperucita) est;
        EstadoAgenteCaperucita estadoCaperucita = ((EstadoAgenteCaperucita) ast);

        estadoCaperucita.increaseVisitedCellsCount();

        int row = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        System.out.println("CAPERUCITA-ambiente: " + row + ", " + col);

        if (row == (EstadoAmbienteCaperucita.CANT_FILAS-1)) {
            return null;
        } else {
            row = row + 1;

            for(int i=row; i<EstadoAmbienteCaperucita.CANT_FILAS; i++){
                environmentState.setPosicionCaperucita(new int[] {row, col});

                if (estadoCaperucita.getBosquePosition(row, col) == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    row = row - 1;
                    environmentState.setPosicionCaperucita(new int[] {row, col});
                    return environmentState;
                }else{
                    return null;
                }
            }
        }

        System.out.println("abajoAmbiente: " + row + ", " + col);

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