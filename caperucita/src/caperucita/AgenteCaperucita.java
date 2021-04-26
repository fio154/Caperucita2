package caperucita;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.Search;

public class AgenteCaperucita extends SearchBasedAgent {

    public AgenteCaperucita() {

        CaperucitaGoal goal = new CaperucitaGoal();

        EstadoAgenteCaperucita estadoCaperucita = new EstadoAgenteCaperucita();
        this.setAgentState(estadoCaperucita);

        Vector<SearchAction> operators = new Vector<SearchAction>();
        //operators.addElement(new Eat());
        //operators.addElement(new Fight());
        operators.addElement(new IrIzquierda());
        operators.addElement(new IrArriba());
        operators.addElement(new IrDerecha());
        operators.addElement(new IrAbajo());

        Problem problem = new Problem(goal, estadoCaperucita, operators);
        this.setProblem(problem);
    }

    @Override
    public Action selectAction() {

        //DepthFirstSearch strategy = new DepthFirstSearch(); //para cambiar el tipo de busqueda
        //GreedySearch strategy = new GreedySearch(new Heuristica());
        //UniformCostSearch strategy = new UnformCostSearch(new FuncionCosto());
        BreathFirstSearch strategy = new BreathFirstSearch();

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