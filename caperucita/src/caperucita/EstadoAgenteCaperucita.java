package caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCaperucita extends SearchBasedAgentState {

    private int[][] bosque;
    private int[] position;
    private int[] initialPosition;
    private int vidas;
    private int visitedCells;

    public EstadoAgenteCaperucita(int[][] b, int row, int col, int e) {
    	bosque = b;
        position = new int[] {row, col};
        initialPosition = new int[2];
        initialPosition[0] = row;
        initialPosition[1] = col;
        vidas = e;
        visitedCells = 0;
    }

    public EstadoAgenteCaperucita() {
    	bosque = new int[EstadoAmbienteCaperucita.CANT_FILAS][EstadoAmbienteCaperucita.CANT_COLUM];
        position = new int[2];
        vidas = 0;
        this.initState();
    }


    @Override
    public SearchBasedAgentState clone() {
        int[][] nuevoBosque = new int[EstadoAmbienteCaperucita.CANT_FILAS][EstadoAmbienteCaperucita.CANT_COLUM];

        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                nuevoBosque[row][col] = bosque[row][col];
            }
        }

        /*int[] newPosition = new int[2];
        newPosition[0] = position[0];
        newPosition[1] = position[1];*/

        EstadoAgenteCaperucita newState = new EstadoAgenteCaperucita(nuevoBosque, this.getRowPosition(), this.getColumnPosition(), this.vidas);

        return newState;
    }

    @Override
    public void updateState(Perception p) {
        PercepcionCaperucita percepcionCaperucita = (PercepcionCaperucita) p;

        int row = this.getRowPosition();
        int col = this.getColumnPosition();

        if (col == 0) {
            col = 8;
        } else {
            col = col - 1;
        }
        bosque[row][col] = percepcionCaperucita.getLeftSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (col == 8) {
            col = 0;
        } else {
            col = col + 1;
        }
        bosque[row][col] = percepcionCaperucita.getRightSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == 0) {
            row = 6;
        } else {
            row = row - 1;
        }
        bosque[row][col] = percepcionCaperucita.getTopSensor();


        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == 6) {
            row = 0;
        } else {
            row = row + 1;
        }
        bosque[row][col] = percepcionCaperucita.getBottomSensor();

        vidas = percepcionCaperucita.getVidas();
    }


    @Override
    public void initState() {
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
            	bosque[row][col] = PercepcionCaperucita.OBSTACULO_PERCEPTION;
            }
        }
        
        /*this.setRowPosition(1);
        this.setColumnPosition(1);*/

        this.setVidas(3);
    }

    @Override
    public String toString() {
        String str = "";

        str = str + " position=\"(" + getRowPosition() + "," + "" + getColumnPosition() + ")\"";
        str = str + " vidas=\"" + vidas + "\"\n";

        str = str + "bosque=\"[ \n";
        for (int row = 0; row < bosque.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < bosque.length; col++) {
                if (bosque[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + bosque[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EstadoAgenteCaperucita))
            return false;

        int[][] bosqueObj = ((EstadoAgenteCaperucita) obj).getBosque();
        int[] positionObj = ((EstadoAgenteCaperucita) obj).getPosition();

        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                if (bosque[row][col] != bosqueObj[row][col]) {
                    return false;
                }
            }
        }

        if (position[0] != positionObj[0] || position[1] != positionObj[1]) {
            return false;
        }
        
        return true;
    }
    
    public int[][] getBosque() {
        return bosque;
    }

    public int getBosquePosition(int row, int col) {
        return bosque[row][col];
    }

    public void setBosquePosition(int row, int col, int value) {
        this.bosque[row][col] = value;
    }

    public int[] getPosition() {
        return position;
    }

    public void setRowPosition(int value) {
        this.position[0] = value;
    }

    public void setColumnPosition(int value) {
        this.position[1] = value;
    }

    public int getRowPosition() {
        return position[0];
    }

    public int getColumnPosition() {
        return position[1];
    }

    public int getVidas() {
        return vidas;
    }

    private void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public boolean esAmbienteConocido() {
        for (int row = 0; row < bosque.length; row++) {
            for (int col = 0; col < bosque.length; col++) {
                if (bosque[row][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public int getCeldasNoConocidas() {
        int result = 0;

        for (int row = 0; row < bosque.length; row++) {
            for (int col = 0; col < bosque.length; col++) {
                if (bosque[row][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    result++;
                }
            }
        }

        return result;
    }

    public int getRemainingFoodCount() {
        int result = 0;

        for (int row = 0; row < bosque.length; row++) {
            for (int col = 0; col < bosque.length; col++) {
                if (bosque[row][col] == PercepcionCaperucita.DULCE_PERCEPTION) {
                    result++;
                }
            }
        }
        
        return result;
    }

    public boolean isNoMoreFood() {
        for (int row = 0; row < bosque.length; row++) {
            for (int col = 0; col < bosque.length; col++) {
                if (bosque[row][col] == PercepcionCaperucita.DULCE_PERCEPTION) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getVisitedCellsCount() {
        return visitedCells;
    }

    public void increaseVisitedCellsCount() {
        this.visitedCells += 1;
    }
}