package caperucita;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteCaperucita extends EnvironmentState{
	
	private int[][] mapa;
	private int[] posicionCaperucita = new int[2];
	private int vidas;

	private int CANT_OBSTACULOS = 15;
	public static int CANT_FILAS = 7;
	public static int CANT_COLUM = 9;
	
	public EstadoAmbienteCaperucita (int[][] m) {
		mapa= m;
	}
	
	public EstadoAmbienteCaperucita() {
		mapa= new int[CANT_FILAS][CANT_COLUM];
		this.initState();
	}
	
	public void initState() {
		for (int row = 0; row < mapa.length; row++) {
			for (int col = 0; col < mapa.length; col++) {
				mapa[row][col] = PercepcionCaperucita.EMPTY_PERCEPTION;
			}
		}

		mapa[0][0]=2;
		mapa[0][4]=-1;
		mapa[0][7]=2;
		mapa[0][8]=-1;

		mapa[1][1]=-1;

		mapa[2][5]=2;
		mapa[2][6]=-1;

		mapa[3][0]=-1;
		mapa[3][1]=-1;
		mapa[3][5]=-1;

		mapa[4][1]=-1;
		mapa[4][2]=-1;

		mapa[5][1]=1; //lobo
		mapa[5][2]=-1;
		mapa[5][3]=-1;
		mapa[5][4]=-1;
		mapa[5][6]=-1;
		mapa[5][8]=-1;

		mapa[6][3]=-1;
		mapa[6][4]=3; //flores
		mapa[6][8]=-1;
		posicionCaperucita[0] = 4;
		posicionCaperucita[1] = 8;

		/*generarPosicionFlores();
		generarPosicionesObstaculosYLobo();
		generarPosicionCaperucita();*/
		this.setVidas(3);
	}
	
	@Override
	public String toString() {
	    String str = "";
	
		str = str + "[ \n";
		for (int row = 0; row < mapa.length; row++) {
		    str = str + "[ ";
		    for (int col = 0; col < mapa.length; col++) {
		    	str = str + mapa[row][col] + " ";
		    }
		    str = str + " ]\n";
		}
		str = str + " ]";
	
	    return str;
	}
	
	public int[][] getMapa() {
	    return mapa;
	}
	
	public void setMapa(int[][] bosque) {
	    this.mapa = bosque;
	}
	
	public void setMapa(int row, int col, int value) {
	    this.mapa[row][col] = value;
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
	        return mapa[3][col];
	    }
	    return mapa[row - 1][col];
	}
	
	public int getLeftCell(int row, int col) {
	    if (col == 0) {
	        return mapa[row][3];
	    }
	    return mapa[row][col - 1];
	}
	
	public int getRightCell(int row, int col) {
	    if (col == 8) {
	        return mapa[row][0];
	    }
	    return mapa[row][col + 1];
	}
	
	public int getBottomCell(int row, int col) {
	    if (row == 3) {
	        return mapa[0][col];
	    }
	    return mapa[row + 1][col];
	}
	
	public void generarPosicionFlores() {
		int [] celda = generarCeldaAleatoria();
		mapa[celda[0]][celda[1]] = 1; //Seteamos posición del camino de flores
	}
	
	public void generarPosicionesObstaculosYLobo() {
		//Generamos una cantidad de obtaculos definidos por una constante y el lobo
		for (int i=0;i<CANT_OBSTACULOS;i++) {
			int [] celda = generarCeldaAleatoria();
			while (mapa[celda[0]][celda[1]] == -1 || mapa[celda[0]][celda[1]] == 3) {
				celda = generarCeldaAleatoria();
			}
			mapa[celda[0]][celda[1]] = -1; //Seteamos posición de obstaculos
		}
		int [] celda = generarCeldaAleatoria();
		while (mapa[celda[0]][celda[1]] == -1 || mapa[celda[0]][celda[1]] == 3) {
			celda = generarCeldaAleatoria();
		}
		mapa[celda[0]][celda[1]] = 1; //Seteamos posición del LOBO
	}

	public void generarPosicionCaperucita() {
		int [] celda = generarCeldaAleatoria();
		while (mapa[celda[0]][celda[1]] == -1 || mapa[celda[0]][celda[1]] == 3 || mapa[celda[0]][celda[1]] == 1) {
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
