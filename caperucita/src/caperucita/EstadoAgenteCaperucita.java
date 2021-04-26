package caperucita.src.caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCaperucita extends SearchBasedAgentState {

    private int[][] bosque;
    private int[] position;
    private int[] initialPosition;
    private int vidas;
    private int visitedCells;
    private int dulces;

    public EstadoAgenteCaperucita(int[][] b, int row, int col, int e, int d) {
    	bosque = b;
        position = new int[] {row, col};
        initialPosition = new int[2];
        initialPosition[0] = row;
        initialPosition[1] = col;
        vidas = e;
        dulces = d;
        visitedCells = 0;
    }

    public EstadoAgenteCaperucita() {
    	bosque = new int[EstadoAmbienteCaperucita.CANT_FILAS][EstadoAmbienteCaperucita.CANT_COLUM];
        position = new int[2];
        vidas = 0;
        dulces = 0;
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

        EstadoAgenteCaperucita newState = new EstadoAgenteCaperucita(bosque, this.getRowPosition(), this.getColumnPosition(), this.vidas, this.dulces);

        return newState;
    }

    @Override
    public void updateState(Perception p) {
        PercepcionCaperucita percepcionCaperucita = (PercepcionCaperucita) p;

        int row = this.getRowPosition();
        int col = this.getColumnPosition();

        if (col == 0) {
            col = EstadoAmbienteCaperucita.CANT_COLUM-1;
        } else {
            col = col - 1;
        }
        bosque[row][col] = percepcionCaperucita.getLeftSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (col == EstadoAmbienteCaperucita.CANT_COLUM-1) {
            col = 0;
        } else {
            col = col + 1;
        }
        bosque[row][col] = percepcionCaperucita.getRightSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == 0) {
            row = EstadoAmbienteCaperucita.CANT_FILAS-1;
        } else {
            row = row - 1;
        }
        bosque[row][col] = percepcionCaperucita.getTopSensor();


        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == EstadoAmbienteCaperucita.CANT_FILAS-1) {
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
            	bosque[row][col] = PercepcionCaperucita.EMPTY_PERCEPTION;
            }
        }

        bosque[0][0]=-1;
        bosque[0][1]=-1;
        bosque[0][2]=-1;
        bosque[0][3]=-1;
        bosque[0][4]=-1;
        bosque[0][5]=-1;
        bosque[0][6]=-1;
        bosque[0][7]=-1;
        bosque[0][8]=-1;
        bosque[0][9]=-1;
        bosque[0][10]=-1;

        bosque[1][0]=-1;
        bosque[2][0]=-1;
        bosque[3][0]=-1;
        bosque[4][0]=-1;
        bosque[5][0]=-1;
        bosque[6][0]=-1;
        bosque[7][0]=-1;

        bosque[8][0]=-1;
        bosque[8][1]=-1;
        bosque[8][2]=-1;
        bosque[8][3]=-1;
        bosque[8][4]=-1;
        bosque[8][5]=-1;
        bosque[8][6]=-1;
        bosque[8][7]=-1;
        bosque[8][8]=-1;
        bosque[8][9]=-1;
        bosque[8][10]=-1;

        bosque[1][10]=-1;
        bosque[2][10]=-1;
        bosque[3][10]=-1;
        bosque[4][10]=-1;
        bosque[5][10]=-1;
        bosque[6][10]=-1;
        bosque[7][10]=-1;


        //mapa[1][1]=2;
        bosque[1][5]=-1;
        //mapa[1][8]=2;
        bosque[1][9]=-1;

        bosque[2][2]=-1;

        //mapa[3][6]=2;
        bosque[3][7]=-1;

        bosque[4][1]=-1;
        bosque[4][2]=-1;
        bosque[4][6]=-1;

        bosque[5][2]=-1;
        bosque[5][3]=-1;

        //mapa[6][2]=1; //lobo
        bosque[6][3]=-1;
        bosque[6][5]=-1;
        bosque[6][5]=-1;
        bosque[6][7]=-1;
        bosque[6][9]=-1;

        bosque[7][4]=-1;
        bosque[7][5]=3; //flores
        bosque[7][9]=-1;

        this.setRowPosition(5);
        this.setColumnPosition(9);

        this.setVidas(3);
        this.setDulces(0);
    }

    @Override
    public String toString() {
        /*String str = "";

        str = str + " position=\"(" + getRowPosition() + "," + "" + getColumnPosition() + ")\"";
        str = str + " vidas=\"" + vidas + "\"\n";

        str = str + "bosque=\"[ \n";
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            str = str + "[ ";
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                if (bosque[row][col] == -1) {
                    str = str + "*";
                } else {
                    str = str + bosque[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;*/

        String str = "";

        str = str + "[ \n";
        for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
            str = str + "[ ";
            for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
                str = str + bosque[row][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    @Override
    public boolean equals(Object obj) {
        /*if (!(obj instanceof EstadoAgenteCaperucita))
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
        
        return true;*/

        return (obj instanceof EstadoAgenteCaperucita) &&
                ((EstadoAgenteCaperucita) obj).getVidas() == this.getVidas() &&
                ((EstadoAgenteCaperucita) obj).getPosition().equals(this.getPosition());
                //((EstadoAgenteCaperucita) obj).getDulces() == this.getDulces();

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
}