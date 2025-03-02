public class State {
    private int x;
    private int y;
    private int height;

    // Constructor
    public State(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Método toString para representación en cadena
    @Override
    public String toString() {
        return "State{" +
                "x=" + x +
                ", y=" + y +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        State state = (State) obj;
        return x == state.x && y == state.y && height == state.height; // Compara valores
    }

}
