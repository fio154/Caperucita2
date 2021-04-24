package caperucita;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class MainBusquedaCaperucita{
	
	public static void main(String[] args) throws PrologConnectorException {
	    AgenteCaperucita agenteCaperucita = new AgenteCaperucita();
	    
	    AmbienteCaperucita ambienteCaperucita = new AmbienteCaperucita();
	    
	    SearchBasedAgentSimulator simulator =
	            new SearchBasedAgentSimulator(ambienteCaperucita, agenteCaperucita);
	    
	    simulator.start();
	}
}