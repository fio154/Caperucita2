package caperucita;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbienteCaperucita extends EnvironmentState{
	
	private int[][] bosque;
	private int[] posicionCaperucita;
	private int vidas;
	
	public EstadoAmbienteCaperucita (int[][] m) {
		bosque= m;
	}
	
	public EstadoAmbienteCaperucita() {
		bosque= new int[4][4];
		this.initState();
	}
	
	public void initState() {
		for (int row = 0; row < bosque.length; row++) {
			for (int col = 0; col < bosque.length; col++) {
				bosque[row][col] = PercepcionCaperucita.EMPTY_PERCEPTION;
			}
		}
		generarPosicionFlores();
		generarPosicionesObstaculosYLobo();
		generarPosicionCaperucita();
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
		
	}
	
	public void generarPosicionesObstaculosYLobo() {
		
	}

	public void generarPosicionCaperucita() {
		
	}
	
}
