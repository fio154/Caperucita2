package caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCaperucita extends SearchBasedAgentState {

    private int[][] world;
    private int[] position;
    private int[] initialPosition;
    private int energy;
    private int visitedCells;

    public EstadoAgenteCaperucita(int[][] m, int row, int col, int e) {
        world = m;
        position = new int[] {row, col};
        initialPosition = new int[2];
        initialPosition[0] = row;
        initialPosition[1] = col;
        energy = e;
        visitedCells = 0;
    }

    public EstadoAgenteCaperucita() {
        world = new int[4][4];
        position = new int[2];
        energy = 0;
        this.initState();
    }


    @Override
    public SearchBasedAgentState clone() {
        int[][] newWorld = new int[4][4];

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                newWorld[row][col] = world[row][col];
            }
        }

        int[] newPosition = new int[2];
        newPosition[0] = position[0];
        newPosition[1] = position[1];

        EstadoAgenteCaperucita newState = new EstadoAgenteCaperucita(newWorld, this.getRowPosition(), this.getColumnPosition(), this.energy);

        return newState;
    }

    @Override
    public void updateState(Perception p) {
        PercepcionCaperucita pacmanPerception = (PercepcionCaperucita) p;

        int row = this.getRowPosition();
        int col = this.getColumnPosition();

        if (col == 0) {
            col = 3;
        } else {
            col = col - 1;
        }
        world[row][col] = pacmanPerception.getLeftSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (col == 3) {
            col = 0;
        } else {
            col = col + 1;
        }
        world[row][col] = pacmanPerception.getRightSensor();

        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == 0) {
            row = 3;
        } else {
            row = row - 1;
        }
        world[row][col] = pacmanPerception.getTopSensor();


        row = this.getRowPosition();
        col = this.getColumnPosition();

        if (row == 3) {
            row = 0;
        } else {
            row = row + 1;
        }
        world[row][col] = pacmanPerception.getBottomSensor();

        energy = pacmanPerception.getVidas();
    }


    @Override
    public void initState() {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                world[row][col] = PercepcionCaperucita.OBSTACULO_PERCEPTION;
            }
        }
        
        this.setRowPosition(1);
        this.setColumnPosition(1);

        this.setEnergy(50);
    }

    @Override
    public String toString() {
        String str = "";

        str = str + " position=\"(" + getRowPosition() + "," + "" + getColumnPosition() + ")\"";
        str = str + " energy=\"" + energy + "\"\n";

        str = str + "world=\"[ \n";
        for (int row = 0; row < world.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + world[row][col] + " ";
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

        int[][] worldObj = ((EstadoAgenteCaperucita) obj).getWorld();
        int[] positionObj = ((EstadoAgenteCaperucita) obj).getPosition();

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] != worldObj[row][col]) {
                    return false;
                }
            }
        }

        if (position[0] != positionObj[0] || position[1] != positionObj[1]) {
            return false;
        }
        
        return true;
    }
    
    public int[][] getWorld() {
        return world;
    }

    public int getWorldPosition(int row, int col) {
        return world[row][col];
    }

    public void setWorldPosition(int row, int col, int value) {
        this.world[row][col] = value;
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

    public int getEnergy() {
        return energy;
    }

    private void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isAllWorldKnown() {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public int getUnknownCellsCount() {
        int result = 0;

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PercepcionCaperucita.OBSTACULO_PERCEPTION) {
                    result++;
                }
            }
        }

        return result;
    }

    public int getRemainingFoodCount() {
        int result = 0;

        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PercepcionCaperucita.DULCE_PERCEPTION) {
                    result++;
                }
            }
        }
        
        return result;
    }

    public boolean isNoMoreFood() {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world.length; col++) {
                if (world[row][col] == PercepcionCaperucita.DULCE_PERCEPTION) {
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
        this.visitedCells = +20;
    }
}