import java.util.LinkedList;
import java.util.List;
    
public class BFQueue {
    private LinkedList<Node> queue;

    public BFQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(Node node) {
        if (queue.isEmpty()) {
            queue.add(node);
            return;
        }
        
        int index = 0;
        for (Node n : queue) {
            if (node.getHeuristic() < n.getHeuristic()) {
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

    public void obtainNodes() {
        for (Node node : queue) {
            System.out.println(node.getState());
        }
    }
}

