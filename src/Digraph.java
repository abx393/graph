import java.util.ArrayList;

public class Digraph {
	private final int V;
	private ArrayList<Integer>[] adj;
	
	public Digraph(int V){
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
