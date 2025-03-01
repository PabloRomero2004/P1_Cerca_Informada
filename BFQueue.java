import java.util.LinkedList;
    
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

    public boolean contains(Node son){
        return queue.contains(son);
    }
}

