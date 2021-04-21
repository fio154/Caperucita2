package caperucita;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.examples.search.pacman.PacmanEnvironmentState;
import frsf.cidisi.faia.examples.search.pacman.PacmanPerception;

public class AmbienteCaperucita extends Environment {

	public AmbienteCaperucita() {
		this.environmentState = new EstadoAmbienteCaperucita();
	}
	
	@Override
	public Perception getPercept() {
		PercepcionCaperucita perception = new PercepcionCaperucita();
		int row = this.getEnvironmentState().getAgentPosition()[4];
		int col = this.getEnvironmentState().getAgentPosition()[4];
		perception.setTopSensor(this.getTopCell(row, col));
		perception.setLeftSensor(this.getLeftCell(row, col));
		perception.setRightSensor(this.getRightCell(row, col));
		perception.setBottomSensor(this.getBottomCell(row, col));
		
		return perception;
	}
	
	@Override
	public boolean agentFailed(Action actionReturned) {
		EstadoAmbienteCaperucita estadoAmbienteCaperucita = this.getEnvironmentState();
		int vidasCaperucita = estadoAmbienteCaperucita.getVidas();
		
		if (vidasCaperucita <= 0)return true;
		
		return false;
	}

    @Override
    public String toString() {
        return environmentState.toString();
    }

    
    public int getTopCell(int row, int col) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getTopCell(row, col);
    }

    public int getLeftCell(int row, int col) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getLeftCell(row, col);
    }

    public int getRightCell(int row, int col) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getRightCell(row, col);
    }

    public int getBottomCell(int row, int col) {
        return ((EstadoAmbienteCaperucita) this.environmentState).getBottomCell(row, col);
    }

}