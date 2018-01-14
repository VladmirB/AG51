package fr.utbm.ag51.tp6;

import java.util.HashMap;
import java.util.Map;

import fr.utbm.ag51.tp6.DikjstraAlgorithm.Graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedGraph<Integer> graph = new DirectedGraph();
		Dijkstra d = new Dijkstra();
		Map<Integer, Double> result = new HashMap<Integer, Double>();
        int t = 9;
        for (int i = 0; i < 9; i++) {
            graph.addNode(i);
        }
        
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 0, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 1, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 2, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 3, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 2, 4);
        graph.addEdge(5, 3, 14);
        graph.addEdge(5, 4, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 0, 8);
        graph.addEdge(7, 1, 11);
        graph.addEdge(7, 6, 1);
        graph.addEdge(7, 8, 7);
        graph.addEdge(8, 2, 2);
        graph.addEdge(8, 6, 6);
        graph.addEdge(8, 7, 7);
        long debut1 = System.nanoTime();
        result=d.shortestPaths(graph, 0);
		  int tp1 = (int) (System.nanoTime()-debut1); 
		  
		  Excel p = new Excel();
		  p.Write(t,tp1, tp1);


	}

}
