package caperucita.src.caperucita;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteCaperucita extends Environment {

	public AmbienteCaperucita() {
		this.environmentState = new EstadoAmbienteCaperucita();
	}


	@Override
	public EstadoAmbienteCaperucita getEnvironmentState() {
		return (EstadoAmbienteCaperucita) super.getEnvironmentState();
	}


	@Override
	public PercepcionCaperucita getPercept() {
		PercepcionCaperucita perception = new PercepcionCaperucita();
		int row = this.getEnvironmentState().getPosicionCaperucita()[0];
		int col = this.getEnvironmentState().getPosicionCaperucita()[1];

		perception.setTopSensorDulce(this.getTopCellDulce(row, col));
		perception.setLeftSensorDulce(this.getLeftCellDulce(row, col));
		perception.setRightSensorDulce(this.getRightCellDulce(row, col));
		perception.setBottomSensorDulce(this.getBottomCellDulce(row, col));

		perception.setTopSensorLobo(this.getTopCellLobo(row, col));
		perception.setLeftSensorLobo(this.getLeftCellLobo(row, col));
		perception.setRightSensorLobo(this.getRightCellLobo(row, col));
		perception.setBottomSensorLobo(this.getBottomCellLobo(row, col));

		return perception;
	}

	@Override
	public boolean agentFailed(Action actionReturned) {
		EstadoAmbienteCaperucita estadoAmbienteCaperucita = this.getEnvironmentState();
		int vidasCaperucita = estadoAmbienteCaperucita.getVidas();

		if (vidasCaperucita <= 0) return true;

		return false;
	}

	@Override
	public String toString() {
		return environmentState.toString();
	}


	public int[] getTopCellDulce(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getTopCellDulce(row, col);
	}

	public int[] getLeftCellDulce(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getLeftCellDulce(row, col);
	}

	public int[] getRightCellDulce(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getRightCellDulce(row, col);
	}

	public int[] getBottomCellDulce(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getBottomCellDulce(row, col);
	}

	public int[] getTopCellLobo(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getTopCellLobo(row, col);
	}

	public int[] getLeftCellLobo(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getLeftCellLobo(row, col);
	}

	public int[] getRightCellLobo(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getRightCellLobo(row, col);
	}

	public int[] getBottomCellLobo(int row, int col) {
		return ((EstadoAmbienteCaperucita) this.environmentState).getBottomCellLobo(row, col);
	}

}

