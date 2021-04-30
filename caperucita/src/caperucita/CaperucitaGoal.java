package caperucita.src.caperucita;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaGoal extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {
        int fila = ((EstadoAgenteCaperucita) agentState).getRowPosition();
        int columna = ((EstadoAgenteCaperucita) agentState).getColumnPosition();

        int tipoCelda = ((EstadoAgenteCaperucita) agentState).getBosquePosition(fila, columna);

        if (tipoCelda==PercepcionCaperucita.FLORES_PERCEPTION && ((EstadoAgenteCaperucita) agentState).getVidas()>=1) {
            return true;
        }

        return false;
    }
}

