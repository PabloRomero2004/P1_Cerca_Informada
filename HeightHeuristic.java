public class HeightHeuristic implements Heuristic{
    public double calculateHeuristic(Node son, Node parent, Node Ef){
        return Math.sqrt(Math.pow(son.getState().getHeight()-(Ef.getState().getHeight()), 2));
    }
}
