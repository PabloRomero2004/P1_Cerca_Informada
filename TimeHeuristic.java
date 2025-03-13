public class TimeHeuristic implements Heuristic {
    public double calculateHeuristic(Node son, Node parent, Node Ef) {
        double upDown = son.getState().getHeight()-Ef.getState().getHeight();

        if (upDown<0){
            upDown = upDown*(-1) + 1;
        }
        else{
            upDown = 0.5;
        }
        
        return (Math.sqrt(Math.pow((son.getState().getX()-(Ef.getState().getX())),2)) 
        + Math.sqrt(Math.pow((son.getState().getY()-(Ef.getState().getY())),2))) 
        * upDown;   //Se multiplique per diffaltura entre el final i la actual si és pujada + 1 o 1/2 si és baixada.
    }
    
}
