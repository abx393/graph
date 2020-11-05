/*
 * Connected Components
 */

import java.util.Arrays;

public class CC {
	private Graph g;
	private int[] id;
	private boolean[] marked; 
	private int count;
	
	public CC(Graph g) {
		this.g = g;
		this.id = new int[g.V()];
		this.marked = new boolean[g.V()];
		this.count = 0;
		
		for (int i = 0; i < marked.length; i++) {
			if (!marked[i]) {
				dfs(i);
				this.count++;
			}
		}
	}
	
	public void dfs(int v) {
		marked[v] = true;
		id[v] = count;
		for (int i: g.adj(v)){
			if (!marked[i]) dfs(i);
		}
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	public void printID() {
		System.out.println(Arrays.toString(id));
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		Graph g = new Graph(30); //creates graph with 8 vertices
		g.randomEdges2(); //adds random edges to the graph
		
		CC c = new CC(g);
		g.printEdges(); //prints each edge twice
		System.out.print("\nConencted Compenents: ");
		System.out.println(c.count());
		c.printID(); //prints id[]  
	}
}
