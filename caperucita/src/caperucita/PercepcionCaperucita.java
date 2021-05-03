package caperucita.src.caperucita;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PercepcionCaperucita extends Perception{

    public static int OBSTACULO_PERCEPTION = -1;
    public static int EMPTY_PERCEPTION = 0;
    public static int LOBO_PERCEPTION = 1;
    public static int DULCE_PERCEPTION = 2;
    public static int FLORES_PERCEPTION = 3;
    private int[] leftSensorDulce;
    private int[] topSensorDulce;
    private int[] rightSensorDulce;
    private int[] bottomSensorDulce;
    private int[] leftSensorLobo;
    private int[] topSensorLobo;
    private int[] rightSensorLobo;
    private int[] bottomSensorLobo;
    private int vidas;
    private int dulces;

    public PercepcionCaperucita() {
        vidas = EstadoAmbienteCaperucita.CANT_VIDAS;
        dulces = 0;
    }

    public PercepcionCaperucita(Agent agent, Environment environment) {

        super(agent, environment);
    }

    @Override
    public void initPerception(Agent agent, Environment environment) {

        AgenteCaperucita agenteCaperucita = (AgenteCaperucita) agent;
        AmbienteCaperucita ambienteCaperucita = (AmbienteCaperucita) environment;
        EstadoAmbienteCaperucita estadoAmbiente = ambienteCaperucita.getEnvironmentState();

        int row = estadoAmbiente.getPosicionCaperucita()[0];
        int col = estadoAmbiente.getPosicionCaperucita()[1];

        this.setTopSensorDulce(estadoAmbiente.getTopCellDulce(row, col));
        this.setLeftSensorDulce(estadoAmbiente.getLeftCellDulce(row, col));
        this.setRightSensorDulce(estadoAmbiente.getRightCellDulce(row, col));
        this.setBottomSensorDulce(estadoAmbiente.getBottomCellDulce(row, col));

        this.setTopSensorLobo(estadoAmbiente.getTopCellLobo(row, col));
        this.setLeftSensorLobo(estadoAmbiente.getLeftCellLobo(row, col));
        this.setRightSensorLobo(estadoAmbiente.getRightCellLobo(row, col));
        this.setBottomSensorLobo(estadoAmbiente.getBottomCellLobo(row, col));

        this.setVidas(estadoAmbiente.getVidas());
        this.setDulces(estadoAmbiente.getDulces());

    }


    public int[] getLeftSensorDulce() {
        return leftSensorDulce;
    }

    public void setLeftSensorDulce(int[] leftSensorDulce) {
        this.leftSensorDulce = leftSensorDulce;
    }

    public int[] getTopSensorDulce() {
        return topSensorDulce;
    }

    public void setTopSensorDulce(int[] topSensorDulce) {
        this.topSensorDulce = topSensorDulce;
    }

    public int[] getRightSensorDulce() {
        return rightSensorDulce;
    }

    public void setRightSensorDulce(int[] rightSensorDulce) {
        this.rightSensorDulce = rightSensorDulce;
    }

    public int[] getBottomSensorDulce() {
        return bottomSensorDulce;
    }

    public void setBottomSensorDulce(int[] bottomSensorDulce) {
        this.bottomSensorDulce = bottomSensorDulce;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getDulces() {
        return dulces;
    }

    public void setDulces(int dulces) {
        this.dulces = dulces;
    }

    public int[] getLeftSensorLobo() {
        return leftSensorLobo;
    }

    public void setLeftSensorLobo(int[] leftSensorLobo) {
        this.leftSensorLobo = leftSensorLobo;
    }

    public int[] getTopSensorLobo() {
        return topSensorLobo;
    }

    public void setTopSensorLobo(int[] topSensorLobo) {
        this.topSensorLobo = topSensorLobo;
    }

    public int[] getRightSensorLobo() {
        return rightSensorLobo;
    }

    public void setRightSensorLobo(int[] rightSensorLobo) {
        this.rightSensorLobo = rightSensorLobo;
    }

    public int[] getBottomSensorLobo() {
        return bottomSensorLobo;
    }

    public void setBottomSensorLobo(int[] bottomSensorLobo) {
        this.bottomSensorLobo = bottomSensorLobo;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Dulces: " + this.dulces);
        str.append("; ");
        str.append("Left Sensor: (" + this.leftSensorDulce[0] + ", " + this.leftSensorDulce[1] + ")");
        str.append("; ");
        str.append("Up Sensor: (" + this.topSensorDulce[0] + ", " + this.topSensorDulce[1] + ")");
        str.append("; ");
        str.append("Right Sensor: (" + this.rightSensorDulce[0] + ", " + this.rightSensorDulce[1] + ")");
        str.append("; ");
        str.append("Down Sensor: (" + this.bottomSensorDulce[0] + ", " + this.bottomSensorDulce[1] + ")");

        str.append("\n");
        str.append("\n");
        str.append("Perception Lobo: ");
        str.append("Left Sensor: (" + this.leftSensorLobo[0] + ", " + this.leftSensorLobo[1] + ")");
        str.append("; ");
        str.append("Up Sensor: (" + this.topSensorLobo[0] + ", " + this.topSensorLobo[1] + ")");
        str.append("; ");
        str.append("Right Sensor: (" + this.rightSensorLobo[0] + ", " + this.rightSensorLobo[1] + ")");
        str.append("; ");
        str.append("Down Sensor: (" + this.bottomSensorLobo[0] + ", " + this.bottomSensorLobo[1] + ")");
        str.append("\n");

        return str.toString();
    }

}
