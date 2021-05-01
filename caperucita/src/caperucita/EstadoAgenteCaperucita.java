package caperucita.src.caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCaperucita extends SearchBasedAgentState {

    private int[][] bosque;
    private int[] position;
    private int[] positionFlores;
    private int[] initialPosition;
    private int vidas;
    private int visitedCells;
    private int dulces;


    public EstadoAgenteCaperucita(int[][] b, int row, int col, int e, int d, int[] posFlores) {
        bosque = b;
        position = new int[] {row, col};
        initialPosition = new int[2];
        initialPosition[0] = row;
        initialPosition[1] = col;
        vidas = e;
        dulces = d;
        visitedCells = 0;
        positionFlores = posFlores;
    }

    public EstadoAgenteCaperucita() {
        bosque = new int[EstadoAmbienteCaperucita.CANT_FILAS][EstadoAmbienteCaperucita.CANT_COLUM];
        position = new int[2];
        vidas = EstadoAmbienteCaperucita.CANT_VIDAS;
        dulces = 0;
        positionFlores = new int[2];
        initialPosition = new int[2];
        initialPosition[0] = EstadoAmbienteCaperucita.FILA_CAPERUCITA;
        initialPosition[1] = EstadoAmbienteCaperucita.COL_CAPERUCITA;
        positionFlores[0] = EstadoAmbienteCaperucita.FILA_FLORES;
        positionFlores[1] = EstadoAmbienteCaperucita.COL_FLORES;
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

        int[] newPosition = new int[2];
        newPosition[0] = position[0];
        newPosition[1] = position[1];

        int[] newPositionFlores = new int[2];
        newPositionFlores[0] = positionFlores[0];
        newPositionFlores[1] = positionFlores[1];

        EstadoAgenteCaperucita newState = new EstadoAgenteCaperucita(nuevoBosque, newPosition[0], newPosition[1], this.vidas, this.dulces, newPositionFlores);

        return newState;
    }

    @Override
    public void updateState(Perception p) {
        PercepcionCaperucita percepcionCaperucita = (PercepcionCaperucita) p;

        int row = this.getRowPosition();
        int col = this.getColumnPosition();

        position[0] = row;
        position[1] = col;

   /*     col = col - 1;
        bosque[row][col] = percepcionCaperucita.getLeftSensor();

        col = this.getColumnPosition();
        col = col + 1;
        bosque[row][col] = percepcionCaperucita.getRightSensor();

        col = this.getColumnPosition();
        row = row - 1;
        bosque[row][col] = percepcionCaperucita.getTopSensor();

        row = this.getRowPosition();
        row = row + 1;
        bosque[row][col] = percepcionCaperucita.getBottomSensor();
*/
        vidas = percepcionCaperucita.getVidas();
    }

    @Override
    public void initState() {
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                bosque[row][col] = PercepcionCaperucita.EMPTY_PERCEPTION;
            }
        }

        /*bosque[0][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][6]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][8]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[1][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[2][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[3][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[4][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[6][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[7][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[8][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][6]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][8]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[8][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[1][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[2][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[3][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[4][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[6][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[7][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        //bosque[1][1]= PercepcionCaperucita.DULCE_PERCEPTION;
        bosque[1][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        //bosque[1][8]= PercepcionCaperucita.DULCE_PERCEPTION;
        bosque[1][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[2][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        //bosque[3][6]= PercepcionCaperucita.DULCE_PERCEPTION;
        bosque[3][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[4][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[4][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[4][6]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[5][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        //bosque[6][2]= PercepcionCaperucita.LOBO_PERCEPTION;
        bosque[6][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[6][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[6][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[6][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[6][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[7][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[7][5]= PercepcionCaperucita.FLORES_PERCEPTION;
        bosque[8][5]= PercepcionCaperucita.FLORES_PERCEPTION;
        bosque[7][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;*/

        mapa6x6();

        this.setRowPosition(EstadoAmbienteCaperucita.FILA_CAPERUCITA);
        this.setColumnPosition(EstadoAmbienteCaperucita.COL_CAPERUCITA);

        this.setVidas(EstadoAmbienteCaperucita.CANT_VIDAS);
        this.setDulces(0);
    }

    public void mapa6x6(){
        bosque[0][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[0][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[5][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[5][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[1][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[2][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[3][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[4][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[1][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[2][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[3][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[4][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

        bosque[2][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
        bosque[4][2]= PercepcionCaperucita.FLORES_PERCEPTION;
    }

    @Override
    public String toString() {
        String str = "";

        str = str + " position=\"(" + this.getRowPosition() + "," + "" + this.getColumnPosition() + ")\"";
        str = str + " vidas=\"" + vidas + "\"\n";

        str = str + "bosque=\"[ \n";
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            str = str + "[ ";
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {

                if(bosque[row][col] == PercepcionCaperucita.FLORES_PERCEPTION){
                    str = str + " F ";
                } else if(row==this.getRowPosition() && col==this.getColumnPosition()){
                    str = str + " C ";
                } else if(bosque[row][col] == PercepcionCaperucita.EMPTY_PERCEPTION){
                    str = str + " - ";
                } else if (bosque[row][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    str = str + " * ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;

        /*String str = "";

        str = str + "[ \n";
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            str = str + "[ ";
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                str = str + bosque[row][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;*/
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof EstadoAgenteCaperucita) &&
                ((EstadoAgenteCaperucita) obj).getPositionFlores().equals(this.positionFlores) &&
                ((EstadoAgenteCaperucita) obj).getVidas() == this.getVidas() &&
                ((EstadoAgenteCaperucita) obj).getPosition().equals(this.getPosition()) &&
                ((EstadoAgenteCaperucita) obj).getDulces() == this.getDulces();
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

    public int getDulces() {
        return dulces;
    }

    private void setDulces(int dulces) {
        this.dulces = dulces;
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
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                if (bosque[row][col] != '*') {
                    result++;
                }
            }
        }
        return result;
    }

    public int getDulcesRestantes() {
        int result = 0;
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                if (bosque[row][col] == PercepcionCaperucita.DULCE_PERCEPTION) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean existenDulces() {  //ACOMODAR FUNCION
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

    public int[] getPositionFlores() {
        return positionFlores;
    }

    public void setPositionFlores(int[] positionFlores) {
        this.positionFlores = positionFlores;
    }
}
