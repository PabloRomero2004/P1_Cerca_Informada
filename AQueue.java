import java.util.LinkedList;
    
public class AQueue {
    private LinkedList<Node> queue;

    public AQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(Node node) {
        if (queue.isEmpty()) {
            queue.add(node);
            return;
        }
        
        int index = 0;
        for (Node n : queue) {
            if (node.getF() < n.getF()) {
                break;
            }
            index++;
        }
        queue.add(index, node);
    }

    public Node dequeue() {
        return queue.isEmpty() ? null : queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }


    public boolean contains(Node node) {
        for (Node elem : queue) {
            if (elem.getState().getX() == node.getState().getX() && elem.getState().getY() == node.getState().getY()) {
                return true; 
            }
        }
        return false;
    }

    public double costInPends(State state) {
        int i=0;
        boolean trobat=false;
        Node elem = null;

        while (i<queue.size() && !trobat) {
            elem = queue.get(i);
            if (elem.getState().getX() == state.getX() && elem.getState().getY() == state.getY()) {
                trobat = true; 
            }

        }
        return elem.getF();
    }

    public void overwrite(Node better){
        int i=0;
        boolean trobat=false;
        Node elem = null;

        while (i<queue.size() && !trobat) {
            elem = queue.get(i);
            if (elem.getState().getX() == better.getState().getX() && elem.getState().getY() == better.getState().getY()) {
                trobat = true; 
            }

        }
        //elem.getF();  //falte substuir

    }

    public void obtainNodes() {
        for (Node node : queue) {
            System.out.println(node.getState());
        }
    }
}

