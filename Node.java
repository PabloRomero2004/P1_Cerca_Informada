import java.util.LinkedList;
import java.util.List;

public class Node {
    private State state;
    private List<State> path;
    private double heuristic;

    // Constructor
    public Node(State state, double heuristic) {
        this.state = state;
        this.heuristic = heuristic;
        this.path = new LinkedList<>();
    }

    // Getters y Setters
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<State> getPath() {
        return path;
    }

    public void addToPath(State state) {
        this.path.add(state);
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }
}