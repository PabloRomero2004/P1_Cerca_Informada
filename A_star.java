import java.util.LinkedList;
import java.util.List;

public class A_star {
    private AQueue pends;
    private int[][] map;
    private List<State> managed;
    private Node Ei, Ef;
    private Heuristic h;

    public A_star(int[][] map, Node Ei, Node Ef, Heuristic h){
       pends = new AQueue();
       managed = new LinkedList<>();
       this.map=map;
       this.Ei = Ei;
       this.Ef = Ef;
       this.h = h;
    }

    public List<State> search() {
        List<State> solution = new LinkedList<>();
        boolean found = false;
        Node parent;

        pends.enqueue(Ei);

        while (!found && pends.size()>0){
            parent = pends.dequeue();
            
            if (parent.getState().equals(Ef.getState())){
                found=true;
                solution=parent.getPath();
            }
            else{
                manageSons(parent, parent.getState().getX()+1, parent.getState().getY());
                manageSons(parent, parent.getState().getX()-1, parent.getState().getY());
                manageSons(parent, parent.getState().getX(), parent.getState().getY()+1);
                manageSons(parent, parent.getState().getX(), parent.getState().getY()-1);
            }
            managed.add(parent.getState());
            
        }

        return solution;
    }


    public void manageSons(Node parent, int x, int y){

        if (x>=0 && y>=0 && x<10 && y<10){
            Node son = new Node(new State(x, y, map[y][x]), 0);
            son.setPath(parent.getPath());

            
            if (son.getState().getHeight() != -1){
                if (!managedState(son.getState())){
                    son.addToPath(son.getState());
                    
                    if(!pends.contains(son)){
                        son.setg(calculateAcum(parent, son));
                        son.setF(h.calculateHeuristic(son, parent, Ef));
                        pends.enqueue(son);
                    }
                    else if (son.getF() < pends.costInPends(son.getState())){
                        pends.overwrite(son);
                    }
                }
            }
        }
    }

    public double calculateAcum(Node parent, Node son){
        double cost = 0;
        
        cost = son.getState().getHeight()-Ef.getState().getHeight();

        if (cost<0){
            cost = cost*(-1) + 1;
        }
        else{
            cost = 1/2;
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
}
