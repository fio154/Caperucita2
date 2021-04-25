package caperucita;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteCaperucita extends EnvironmentState{
	
	private int[][] bosque;
	private int[] posicionCaperucita;
	private int vidas;

	private int CANT_OBSTACULOS = 15;
	private int CANT_FILAS = 7;
	private int CANT_COLUM = 9;
	
	public EstadoAmbienteCaperucita (int[][] m) {
		bosque= m;
	}
	
	public EstadoAmbienteCaperucita() {
		bosque= new int[CANT_FILAS][CANT_COLUM];
		this.initState();
	}
	
	public void initState() {
		for (int row = 0; row < bosque.length; row++) {
			for (int col = 0; col < bosque.length; col++) {
				bosque[row][col] = PercepcionCaperucita.EMPTY_PERCEPTION;
			}
		}
		bosque[1][1]=2;
		bosque[1][5]=-1;
		bosque[1][8]=2;
		bosque[1][9]=-1;
		bosque[2][1]=-1;
		bosque[2][3]=-1;
		bosque[3][6]=2;
		bosque[3][7]=-1;
		bosque[4][1]=-1;
		bosque[4][2]=-1;
		bosque[4][6]=-1;
		bosque[5][2]=-1;
		bosque[5][3]=-1;
		bosque[6][2]=1; //lobo
		bosque[6][3]=-1;
		bosque[6][4]=-1;
		bosque[6][5]=-1;
		bosque[6][7]=-1;
		bosque[6][9]=-1;
		bosque[7][4]=-1;
		bosque[7][5]=3;//flores
		/*generarPosicionFlores();
		generarPosicionesObstaculosYLobo();
		generarPosicionCaperucita();*/
		this.setVidas(3);
	}
	
	@Override
	public String toString() {
	    String str = "";
	
		str = str + "[ \n";
		for (int row = 0; row < bosque.length; row++) {
		    str = str + "[ ";
		    for (int col = 0; col < bosque.length; col++) {
		    	str = str + bosque[row][col] + " ";
		    }
		    str = str + " ]\n";
		}
		str = str + " ]";
	
	    return str;
	}
	
	public int[][] getBosque() {
	    return bosque;
	}
	
	public void setBosque(int[][] bosque) {
	    this.bosque = bosque;
	}
	
	public void setBosque(int row, int col, int value) {
	    this.bosque[row][col] = value;
	}
	
	public int[] getPosicionCaperucita() {
	    return posicionCaperucita;
	}
	
	public void setPosicionCaperucita(int[] posicionCaperucita) {
	    this.posicionCaperucita = posicionCaperucita;
	}
	
	public int getVidas() {
	    return vidas;
	}
	
	public void setVidas(int vidas) {
	    this.vidas = vidas;
	}
	
	public int getTopCell(int row, int col) {
	    if (row == 0) {
	        return bosque[3][col];
	    }
	    return bosque[row - 1][col];
	}
	
	public int getLeftCell(int row, int col) {
	    if (col == 0) {
	        return bosque[row][3];
	    }
	    return bosque[row][col - 1];
	}
	
	public int getRightCell(int row, int col) {
	    if (col == 3) {
	        return bosque[row][0];
	    }
	    return bosque[row][col + 1];
	}
	
	public int getBottomCell(int row, int col) {
	    if (row == 3) {
	        return bosque[0][col];
	    }
	    return bosque[row + 1][col];
	}
	
	public void generarPosicionFlores() {
		int [] celda = generarCeldaAleatoria();
		bosque[celda[0]][celda[1]] = 1; //Seteamos posición del camino de flores
	}
	
	public void generarPosicionesObstaculosYLobo() {
		//Generamos una cantidad de obtaculos definidos por una constante y el lobo
		for (int i=0;i<CANT_OBSTACULOS;i++) {
			int [] celda = generarCeldaAleatoria();
			while (bosque[celda[0]][celda[1]] == -1 || bosque[celda[0]][celda[1]] == 3) {
				celda = generarCeldaAleatoria();
			}
			bosque[celda[0]][celda[1]] = -1; //Seteamos posición de obstaculos
		}
		int [] celda = generarCeldaAleatoria();
		while (bosque[celda[0]][celda[1]] == -1 || bosque[celda[0]][celda[1]] == 3) {
			celda = generarCeldaAleatoria();
		}
		bosque[celda[0]][celda[1]] = 1; //Seteamos posición del LOBO
	}

	public void generarPosicionCaperucita() {
		int [] celda = generarCeldaAleatoria();
		while (bosque[celda[0]][celda[1]] == -1 || bosque[celda[0]][celda[1]] == 3 || bosque[celda[0]][celda[1]] == 1) {
			celda = generarCeldaAleatoria();
		}
		posicionCaperucita[0] = celda[0];
		posicionCaperucita[1] = celda[1];
	}

	public int[] generarCeldaAleatoria() { //Generamos una fila y columna aleatorias
		int[] celda = new int[2];
		celda[0] = (int) Math.floor(Math.random()*CANT_FILAS);
		celda[1] = (int) Math.floor(Math.random()*CANT_COLUM);
		return celda;
	}
	
}
