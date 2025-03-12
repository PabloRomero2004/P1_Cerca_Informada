import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node {
    private State state;
    private List<State> path;
    private double heuristic;
    private double f;           //CostTotal
    private double g;           //Cost acum

    // Constructor
    public Node(State state, double heuristic) {
        this.state = state;
        this.heuristic = heuristic;
        this.path = new LinkedList<>();
        this.f=0;
        this.g=0;
    }

    // Getters y Setters
    public State getState() {
        return state;
    }

    public double getF() {
        return f;
    }

    public double getg() {
        return g;
    }

    public void setState(State state) {
        this.state = state;
    }


    public List<State> getPath() {
        List<State> pathCopy = new ArrayList<>();
        for (State state : path) {
            pathCopy.add(new State(state.getX(), state.getY(), state.getHeight())); // Nueva instancia
        }
        return pathCopy;
    }


    public void addToPath(State state) {
        this.path.add(state);
    }

    public void setPath(List<State> path) {
        for (State x:path){
            this.path.add(x);
        }
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setF(double h) {
        this.f = h+this.g;
    }

    public double setg(double lastg) {
        return this.g+=lastg;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }
}