package caperucita;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class CaperucitaGoal extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {
        if (((EstadoAgenteCaperucita) agentState).isNoMoreFood() &&
                ((EstadoAgenteCaperucita) agentState).isAllWorldKnown()) {
            return true;
        }
        return false;
    }
}
