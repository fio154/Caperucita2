package caperucita.src.caperucita;


import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteCaperucita extends EnvironmentState {

	private int[][] mapa;
	private int[] posicionCaperucita;
	private int vidas;
	private int dulces;

	private int CANT_OBSTACULOS = 15;
	public static int CANT_VIDAS = 3;
	public static int CANT_FILAS = 6;
	public static int CANT_COLUM = 6;
	public static int FILA_FLORES = 1;
	public static int COL_FLORES = 3;
	public static int FILA_CAPERUCITA = 1;
	public static int COL_CAPERUCITA = 1;

	public EstadoAmbienteCaperucita (int[][] m) {
		mapa= m;
	}

	public EstadoAmbienteCaperucita() {
		mapa = new int[CANT_FILAS][CANT_COLUM];
		vidas = CANT_VIDAS;
		posicionCaperucita = new int[2];
		this.initState();
	}

	public void initState() {
		for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
			for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
				mapa[row][col] = PercepcionCaperucita.EMPTY_PERCEPTION;
			}
		}

      /*mapa[0][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][6]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][8]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[0][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      mapa[1][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[2][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[3][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[4][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[5][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[6][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[7][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      mapa[8][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][6]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][8]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[8][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      mapa[1][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[2][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[3][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[4][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[5][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[6][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[7][10]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      //mapa[1][1]= PercepcionCaperucita.DULCE_PERCEPTION;
      mapa[1][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      //mapa[1][8]= PercepcionCaperucita.DULCE_PERCEPTION;
      mapa[1][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      mapa[2][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      //mapa[3][6]= PercepcionCaperucita.DULCE_PERCEPTION;
      mapa[3][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      mapa[4][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[4][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[4][6]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      mapa[5][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[5][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      //mapa[6][2]= PercepcionCaperucita.LOBO_PERCEPTION;
      mapa[6][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[6][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[6][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[6][7]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[6][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

      mapa[7][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
      mapa[EstadoAmbienteCaperucita.FILA_FLORES][EstadoAmbienteCaperucita.COL_FLORES]= PercepcionCaperucita.FLORES_PERCEPTION;
      mapa[8][5]= PercepcionCaperucita.FLORES_PERCEPTION;
      mapa[7][9]= PercepcionCaperucita.OBSTACULO_PERCEPTION;*/

		mapa6x6();
		posicionCaperucita[0] = EstadoAmbienteCaperucita.FILA_CAPERUCITA;
		posicionCaperucita[1] = EstadoAmbienteCaperucita.COL_CAPERUCITA;


      /*generarPosicionFlores();
      generarPosicionesObstaculosYLobo();
      generarPosicionCaperucita();
      generarPosicionDulces();*/
	}

	public void mapa6x6(){
		mapa[0][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[0][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[0][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[0][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[0][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[0][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

		mapa[5][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[5][1]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[5][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[5][3]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[5][4]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[5][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

		mapa[1][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[2][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[3][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[4][0]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

		mapa[1][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[2][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[3][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;
		mapa[4][5]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

		//mapa[1][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

		mapa[2][2]= PercepcionCaperucita.OBSTACULO_PERCEPTION;

		mapa[2][4]= PercepcionCaperucita.DULCE_PERCEPTION;
		mapa[4][3]= PercepcionCaperucita.DULCE_PERCEPTION;
		mapa[3][1]= PercepcionCaperucita.DULCE_PERCEPTION;

		mapa[EstadoAmbienteCaperucita.FILA_FLORES][EstadoAmbienteCaperucita.COL_FLORES]= PercepcionCaperucita.FLORES_PERCEPTION;

		mapa[4][3]= PercepcionCaperucita.LOBO_PERCEPTION;
	}

	@Override
	public String toString() {
		String str = "";

		str = str + "[ \n";
		for (int row = 0; row < EstadoAmbienteCaperucita.CANT_FILAS; row++) {
			str = str + "[ ";
			for (int col = 0; col < EstadoAmbienteCaperucita.CANT_COLUM; col++) {
				if(mapa[row][col]!=PercepcionCaperucita.OBSTACULO_PERCEPTION) str = str + " ";
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

	public int[] getTopCellDulce(int row, int col) {

		int[] posicion = new int[2];

		for(int i=row; i>=1; i--){
			if(getMapa()[i-1][col] == PercepcionCaperucita.DULCE_PERCEPTION){
				posicion[0] = i - 1;
				posicion[1] = col;
				return posicion;
			}
		}

		return posicion;
	}

	public int[] getLeftCellDulce(int row, int col) {

		int[] posicion = new int[2];

		for(int i=col; i>=1; i--){
			if(getMapa()[row][i-1] == PercepcionCaperucita.DULCE_PERCEPTION){
				posicion[0] = row;
				posicion[1] = i - 1;
				return posicion;
			}
		}

		return posicion;

	}

	public int[] getRightCellDulce(int row, int col) {
		int[] posicion = new int[2];

		for(int i=col; i<(EstadoAmbienteCaperucita.CANT_COLUM-1); i++){
			if(getMapa()[row][i + 1] == PercepcionCaperucita.DULCE_PERCEPTION){
				posicion[0] = row;
				posicion[1] = i + 1;
				return posicion;
			}
		}

		return posicion;
	}

	public int[] getBottomCellDulce(int row, int col) {
		int[] posicion = new int[2];

		for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS-1); i++){
			if(getMapa()[i + 1][col] == PercepcionCaperucita.DULCE_PERCEPTION){
				posicion[0] = i + 1;
				posicion[1] = col;
				return posicion;
			}
		}

		return posicion;
	}

	public int[] getTopCellLobo(int row, int col) {

		int[] posicion = new int[2];

		for(int i=row; i>=1; i--){
			if(getMapa()[i-1][col] == PercepcionCaperucita.LOBO_PERCEPTION){
				posicion[0] = i - 1;
				posicion[1] = col;
				return posicion;
			}
		}

		return posicion;
	}

	public int[] getLeftCellLobo(int row, int col) {

		int[] posicion = new int[2];

		for(int i=col; i>=1; i--){
			if(getMapa()[row][i-1] == PercepcionCaperucita.LOBO_PERCEPTION){
				posicion[0] = row;
				posicion[1] = i - 1;
				return posicion;
			}
		}

		return posicion;

	}

	public int[] getRightCellLobo(int row, int col) {
		int[] posicion = new int[2];

		for(int i=col; i<(EstadoAmbienteCaperucita.CANT_COLUM-1); i++){
			if(getMapa()[row][i + 1] == PercepcionCaperucita.LOBO_PERCEPTION){
				posicion[0] = row;
				posicion[1] = i + 1;
				return posicion;
			}
		}

		return posicion;
	}

	public int[] getBottomCellLobo(int row, int col) {
		int[] posicion = new int[2];

		for(int i=row; i<(EstadoAmbienteCaperucita.CANT_FILAS-1); i++){
			if(getMapa()[i + 1][col] == PercepcionCaperucita.LOBO_PERCEPTION){
				posicion[0] = i + 1;
				posicion[1] = col;
				return posicion;
			}
		}

		return posicion;
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
