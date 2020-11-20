/*
 * Data structure- Graph stored as an array of adjacency lists
 * Consists of some number of vertices and some number of edges connecting them
 * Edges can have weights associated with them.
 */

import java.util.ArrayList;

public class EdgeWeightedGraph {
	private ArrayList<Integer>[] adj;
	
	public EdgeWeightedGraph(int V) {
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int i = 0; i < adj.length; i++){
			this.adj[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(Edge e) {
		int v = e.first();
		int w = e.second(v);
     
		// adding the edge to the adjacency list
		this.adj[v].add(w);
		this.adj[w].add(v);
	}
	
	// Depth First Search- traverses each vertex in the graph exactly once
	public void dfs() {
		boolean[] visited = new boolean[adj.length];
		dfs(2, visited);
	}
	
	// Depth First Search
	public void dfs(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.println(vertex);
		for (int v : adj[vertex]){
			if (!visited[v]) dfs(v, visited);
		}
	}

	public static void main(String[] args) {
		// testing
		EdgeWeightedGraph g = new EdgeWeightedGraph(5);
		g.addEdge(new Edge(0, 1, 5));
		g.addEdge(new Edge(1, 2, 10));
		g.addEdge(new Edge(3, 4, 2));
		g.addEdge(new Edge(4, 2, 6));
		
		g.dfs();
		
	}
}

class Edge {
	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int first() {
		return this.v;
	}

	public int second(int vertex) {
		if (vertex == v) return w;
		else return v;
	}
}
