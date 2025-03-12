import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filename = "mapa1.txt";  // Cambia esto por la ruta real del archivo
        List<State> solList = new LinkedList<>(); 
        
        int[][] map = null;
        try {
            map = getMap(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Node start = new Node(new State(0, 0, map[0][0]), 0);
        start.addToPath(new State(0, 0, map[0][0]));
        Node end = new Node(new State(9, 9, map[9][9]), 0);

        System.out.println("Distància hohoi");
        Heuristic h = new DistanceHeuristic();          //declarem el tipus de heuristica que utilitzarem

        BFSearch BF = new BFSearch(map, start, end, h);

        solList=BF.search();

        if (!solList.isEmpty()) {
            for (State state : solList) {
                System.out.println("("+state.getX()+", "+state.getY()+") ");
            }
        }
        else {
            System.out.println("No hi ha solució");
        }


        System.out.println("\n\nAltura hohoi");
        h = new HeightHeuristic();          //declarem el tipus de heuristica que utilitzarem

        BF = new BFSearch(map, start, end, h);

        solList=BF.search();

        if (!solList.isEmpty()) {
            for (State state : solList) {
                System.out.println("("+state.getX()+", "+state.getY()+") ");
            }
        }
        else {
            System.out.println("No hi ha solució");
        }



        System.out.println("\n\nTemps hohoi");
        h = new TimeHeuristic();          //declarem el tipus de heuristica que utilitzarem

        BF = new BFSearch(map, start, end, h);

        solList=BF.search();

        if (!solList.isEmpty()) {
            for (State state : solList) {
                System.out.println("("+state.getX()+", "+state.getY()+") ");
            }
        }
        else {
            System.out.println("No hi ha solució");
        }
        
    }


    public static int[][] getMap(String filename) throws IOException {
        int[][] map = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int rows = 0;
            int columns = 0;
            StringBuilder height = new StringBuilder();

            while ((line = br.readLine()) != null) {
                height.append(line).append("\n");
                rows++;
            }

            String[] lines = height.toString().split("\n");
            columns = lines[0].split(",").length;
            
            map = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                String[] valores = lines[i].split(",");
                for (int j = 0; j < columns; j++) {
                    map[i][j] = Integer.parseInt(valores[j]);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato del archivo: " + e.getMessage());
        }

        return map;
    }

}

