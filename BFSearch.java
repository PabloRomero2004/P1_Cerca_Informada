import java.util.LinkedList;
import java.util.List;

public class BFSearch{
    private BFQueue pends;
    private int[][] map;
    private List<State> managed;
    private Node Ei, Ef;
    private Heuristic h;

    public BFSearch(int[][] map, Node Ei, Node Ef, Heuristic h){
       pends = new BFQueue();
       managed = new LinkedList<>();
       this.map=map;
       this.Ei = Ei;
       this.Ef = Ef;
       this.h = h;
    }

    public Node search() {
        boolean found = false;
        Node parent = null;

        pends.enqueue(Ei);
        int iter=0;

        while (!found && pends.size()>0){
            parent = pends.dequeue();
            
            if (parent.getState().equals(Ef.getState())){
                found=true;
            }
            else{
                manageSons(parent, parent.getState().getX()+1, parent.getState().getY());
                manageSons(parent, parent.getState().getX()-1, parent.getState().getY());
                manageSons(parent, parent.getState().getX(), parent.getState().getY()+1);
                manageSons(parent, parent.getState().getX(), parent.getState().getY()-1);
            }
            managed.add(parent.getState());
            iter++;
        }

        parent.setIter(iter);
        return parent;
    }


    public void manageSons(Node parent, int x, int y){
        
        if (x>=0 && y>=0 && x<10 && y<10){
            Node son = new Node(new State(x, y, map[y][x]), 0);
            son.setPath(parent.getPath());

            if (son.getState().getHeight() != -1){
                if (!managedState(son.getState()) && !pends.contains(son)){
                    son.addToPath(son.getState());
                    son.setHeuristic(h.calculateHeuristic(son, parent, Ef));
                    son.setg(calculateAcum(parent, son), parent.getg());
                    pends.enqueue(son);
                }
            }
        }
    }

    public double calculateAcum(Node parent, Node son){
        double cost = 0;
        
        cost = son.getState().getHeight()-parent.getState().getHeight();

        if (cost>=0){
            cost = cost + 1;
        }
        else{
            cost = 0.5;
        }

        return cost;
    }

    public boolean managedState(State state) {
        for (State elem : managed) {
            if (elem.getX() == state.getX() && elem.getY() == state.getY()) {
                return true; 
            }
        }
        return false;
    }
    

    /*public double calculateHeuristic (State parent, State son){
        return time_move(parent.getHeight(), son.getHeight()) + dist_final(son.getX(),son.getY()) + diff_height(son.getHeight());
    }

    public double time_move(int parentz, int sonz){
        double time=0;
        if (parentz-sonz == 0){
            time=1;
        }
        else if(parentz-sonz>0){
            time = parentz-sonz + 1;
        }
        else{
            time = 1/2;
        }
        
        return time;
    }


    public double dist_final(int actualx, int actualy){
        return Math.sqrt(Math.pow((actualx-(Ef.getState().getX())),2) + Math.pow((actualy-(Ef.getState().getY())),2));
    }


    public double diff_height(int actualz){
        return Math.sqrt(Math.pow(actualz-(Ef.getState().getHeight()), 2));
    }*/
}

    
