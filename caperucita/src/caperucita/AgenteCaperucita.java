package caperucita;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgenteCaperucita extends SearchBasedAgent {

    public AgenteCaperucita() {

        // The Pacman Goal
        PacmanGoal goal = new PacmanGoal();

        // The Pacman Agent State
        EstadoAmbienteCaperucita estadoCaperucita = new EstadoAgenteCaperucita();
        this.setAgentState(estadoCaperucita);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new Eat());
        operators.addElement(new Fight());
        operators.addElement(new GoLeft());
        operators.addElement(new GoUp());
        operators.addElement(new GoRight());
        operators.addElement(new GoDown());

        Problem problem = new Problem(goal, estadoCaperucita, operators);
        this.setProblem(problem);
    }

    @Override
    public Action selectAction() {

        DepthFirstSearch strategy = new DepthFirstSearch();

        Search searchSolver = new Search(strategy);

        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        this.setSolver(searchSolver);

        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgenteCaperucita.class.getName()).log(Level.SEVERE, null, ex);
        }

        return selectedAction;
    }

    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}