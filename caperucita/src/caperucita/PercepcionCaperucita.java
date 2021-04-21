package caperucita;
	
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
	
public class PercepcionCaperucita extends Perception{

	public static int OBSTACULO_PERCEPTION = -1;
	public static int EMPTY_PERCEPTION = 0;
	public static int LOBO_PERCEPTION = 1;
	public static int DULCE_PERCEPTION = 2;
	private int leftSensor;
	private int topSensor;
	private int rightSensor;
	private int bottomSensor;
	private int vidas;
	
	public PercepcionCaperucita() {
		vidas= 3;
	}
	
	public PercepcionCaperucita(Agent agent, Environment environment) {
		super(agent, environment);
	}
	
	public void initPerception(Agent agent, Environment environment) {
		
		AgenteCaperucita agenteCaperucita = (AgenteCaperucita) agent;
		AmbienteCaperucita ambienteCaperucita = (AmbienteCaperucita) ambiente;
		EstadoAmbienteCaperucita estadoAmbiente = ambienteCaperucita.getEnvironmentState();
		int row = environmentState.getAgentPosition()[0];
		int col = environmentState.getAgentPosition()[1];
		this.setTopSensor(pacmanEnvironment.getTopCell(row, col));
		this.setLeftSensor(pacmanEnvironment.getLeftCell(row, col));
		this.setRightSensor(pacmanEnvironment.getRightCell(row, col));
		this.setBottomSensor(pacmanEnvironment.getBottomCell(row, col));
		
	}
	
	
	public int getLeftSensor() {
        return leftSensor;
    }

    public void setLeftSensor(int leftSensor) {
        this.leftSensor = leftSensor;
    }

    public int getTopSensor() {
        return topSensor;
    }

    public void setTopSensor(int topSensor) {
        this.topSensor = topSensor;
    }

    public int getRightSensor() {
        return rightSensor;
    }

    public void setRightSensor(int rightSensor) {
        this.rightSensor = rightSensor;
    }

    public int getBottomSensor() {
        return bottomSensor;
    }

    public void setBottomSensor(int bottomSensor) {
        this.bottomSensor = bottomSensor;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Vidas: " + this.vidas);
        str.append("; ");
        str.append("Left Sensor: " + this.leftSensor);
        str.append("; ");
        str.append("Up Sensor: " + this.topSensor);
        str.append("; ");
        str.append("Right Sensor: " + this.rightSensor);
        str.append("; ");
        str.append("Down Sensor: " + this.bottomSensor);

        return str.toString();
    }
	
}