package caperucita.src.caperucita;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteCaperucita extends EnvironmentState{
	
	private int[][] mapa;
	private int[] posicionCaperucita = new int[2];
	private int vidas;
	private int dulces;

	private int CANT_OBSTACULOS = 15;
	public static int CANT_DULCES = 3;
	public static int CANT_VIDAS = 3;
	public static int CANT_FILAS = 9;
	public static int CANT_COLUM = 11;
	
	public EstadoAmbienteCaperucita (int[][] m) {
		mapa= m;
	}
	
	public EstadoAmbienteCaperucita() {
		mapa = new int[CANT_FILAS][CANT_COLUM];
		this.initState();
	}
	
	public void initState() {
		for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
			for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
				mapa[row][col] = PercepcionCaperucita.EMPTY_PERCEPTION;
			}
		}

		mapa[0][0]=-1;
		mapa[0][1]=-1;
		mapa[0][2]=-1;
		mapa[0][3]=-1;
		mapa[0][4]=-1;
		mapa[0][5]=-1;
		mapa[0][6]=-1;
		mapa[0][7]=-1;
		mapa[0][8]=-1;
		mapa[0][9]=-1;
		mapa[0][10]=-1;

		mapa[1][0]=-1;
		mapa[2][0]=-1;
		mapa[3][0]=-1;
		mapa[4][0]=-1;
		mapa[5][0]=-1;
		mapa[6][0]=-1;
		mapa[7][0]=-1;

		mapa[8][0]=-1;
		mapa[8][1]=-1;
		mapa[8][2]=-1;
		mapa[8][3]=-1;
		mapa[8][4]=-1;
		mapa[8][5]=-1;
		mapa[8][6]=-1;
		mapa[8][7]=-1;
		mapa[8][8]=-1;
		mapa[8][9]=-1;
		mapa[8][10]=-1;

		mapa[1][10]=-1;
		mapa[2][10]=-1;
		mapa[3][10]=-1;
		mapa[4][10]=-1;
		mapa[5][10]=-1;
		mapa[6][10]=-1;
		mapa[7][10]=-1;


		//mapa[1][1]=2;
		mapa[1][5]=-1;
		//mapa[1][8]=2;
		mapa[1][9]=-1;

		mapa[2][2]=-1;

		//mapa[3][6]=2;
		mapa[3][7]=-1;

		mapa[4][1]=-1;
		mapa[4][2]=-1;
		mapa[4][6]=-1;

		mapa[5][2]=-1;
		mapa[5][3]=-1;

		//mapa[6][2]=1; //lobo
		mapa[6][3]=-1;
		mapa[6][5]=-1;
		mapa[6][5]=-1;
		mapa[6][7]=-1;
		mapa[6][9]=-1;

		mapa[7][4]=-1;
		mapa[7][5]=3; //flores
		mapa[7][9]=-1;
		posicionCaperucita[0] = 5;
		posicionCaperucita[1] = 9;

		/*generarPosicionFlores();
		generarPosicionesObstaculosYLobo();
		generarPosicionCaperucita();
		generarPosicionDulces();*/
		this.setVidas(CANT_VIDAS);
		this.setDulces(CANT_DULCES);
	}
	
	@Override
	public String toString() {
	    String str = "";
	
		str = str + "[ \n";
		for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
		    str = str + "[ ";
		    for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
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

	public int getDulces() {
		return dulces;
	}

	public void setDulces(int dulces) {
		this.dulces = dulces;
	}
	
	public int getTopCell(int row, int col) {
	    if (row == 0) {
	        return mapa[EstadoAmbienteCaperucita.CANT_FILAS-1][col];
	    }
	    return mapa[row - 1][col];
	}
	
	public int getLeftCell(int row, int col) {
	    if (col == 0) {
	        return mapa[row][EstadoAmbienteCaperucita.CANT_COLUM-1];
	    }
	    return mapa[row][col - 1];
	}
	
	public int getRightCell(int row, int col) {
	    if (col == EstadoAmbienteCaperucita.CANT_COLUM-1) {
	        return mapa[row][0];
	    }
	    return mapa[row][col + 1];
	}
	
	public int getBottomCell(int row, int col) {
	    if (row == EstadoAmbienteCaperucita.CANT_FILAS-1) {
	        return mapa[0][col];
	    }
	    return mapa[row + 1][col];
	}
	
	public void generarPosicionFlores() { //fijarse que sea en el borde
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
