public class DistanceHeuristic implements Heuristic {
    public double calculateHeuristic(Node son, Node parent, Node Ef){
        return Math.sqrt(Math.pow((son.getState().getX()-(Ef.getState().getX())),2) + Math.pow((son.getState().getY()-(Ef.getState().getY())),2));
    }
}
