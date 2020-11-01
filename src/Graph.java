import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;

public class Graph {
	private final int V;
	private ArrayList<Integer>[] adj;
	
	public Graph(int V){
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int i=0; i<V; i++){
			adj[i] = new ArrayList<Integer>();
		}
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	public void printEdges(){
		for (int i=0; i<V; i++){
			for (int j: adj[i]){
				System.out.println(i + " " + j);
			}
		}
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	//graph is fully connected
	public void randomEdges(){
		for (int i=0; i<V; i++){
			int rand = new Random().nextInt(V);
			addEdge(i, rand);
			addEdge(i, V-1-rand);
		}
	}
	public void randomEdges2(){
		for (int i=0; i<V; i++){
			if (new Random().nextInt(4)<3){
				int rand = new Random().nextInt(V);
				addEdge(i, rand);
			}
		}
	}
	//depth first search
	public void dfs(){
		boolean[] marked = new boolean[V];
		dfs(0, marked);
	}
	public void dfs(int vertex, boolean[] marked){
		marked[vertex] = true;
		System.out.println(vertex);
		for (int v: adj[vertex]){
			if (!marked[v]) dfs(v, marked);
		}
	}
	//Breadth First Search
	public void bfs(){
		boolean[] visited = new boolean[V];
		Arrays.fill(visited,  false);
		Queue<Integer> unvisited = new LinkedList<Integer>();
		unvisited.add(0);
		bfs(visited, unvisited);
	}
	public void bfs(boolean[] visited, Queue<Integer> unvisited){
		while (unvisited.size()>0){
			int vertex = unvisited.remove();
			visited[vertex] = true;
			System.out.println(vertex);
			for (int v: adj[vertex]){
				if (!visited[v]) {
					unvisited.add(v);
					visited[v] = true;
				}
			}
		}
	}
	public int V(){
		return V;
	}
	public static void main(String[] args){
		Graph g = new Graph(8);
		g.randomEdges();
		System.out.println("Depth First Search:");
		g.dfs();
		System.out.println("\nBreadth First Search:");
		g.bfs();
	}
}
