import java.util.ArrayList;

public class Digraph {
	private final int V;
	private ArrayList<Integer>[] adj;
	
	public Digraph(int V) {
		this.V = V;
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
	}
  
	public void addEdge(int v, int w) {
		this.adj[v].add(w);
	}

	public Iterable<Integer> adj(int v) {
		return this.adj[v];
	}
}
