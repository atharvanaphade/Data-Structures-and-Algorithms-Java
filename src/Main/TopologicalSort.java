package Main;

import java.io.*;
import java.util.*;
/**
 * @version 6.96969
 * @author atharvanaphade
 * 
 * <h1>Topological Sort</h1>
 * 
 * <p>Topological Sort is the ordering of a directed graph nodes where in if A -> b, then A will always be before B.</p>
 * <p>The graph must not have cycles, because the egg cannot come before the chicken came before the egg, if you know what i mean :).</p>
 */

public class TopologicalSort {
	public class Graph {
		private Integer V;
		private ArrayList<ArrayList<Integer>> adj;
		
		public Graph (int v) {
			V = v;
			adj = new ArrayList<ArrayList<Integer>>(v);
			for (int i = 0; i < v; i++) {
				adj.add(new ArrayList<Integer>());
			}
		}
		
		public void AddEdge(int v, int w) {
			adj.get(v).add(w);
		}
		
		public ArrayList<Integer> TopologicalSort () {
			ArrayList<Integer> ret = new ArrayList<>();
			Stack<Integer> st = new Stack<Integer>();
			boolean[] visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				visited[i] = false;
			}
			for (int i = 0; i < V; i++) {
				if (visited[i] == false) {
					TopologicalSortUtil(i, visited, st);
				}
			}
			while (st.empty() == false) {
				ret.add(st.pop());
			}
			return ret;
		}
		
		public void TopologicalSortUtil (int v, boolean[] visited, Stack<Integer> st) {
			visited[v] = true;
			Integer i;
			
			Iterator<Integer> it = adj.get(v).iterator();
			while (it.hasNext()) {
				i = it.next();
				if (!visited[i]) {
					TopologicalSortUtil(i, visited, st);
				}
			}
			st.push(new Integer(v));
		}
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	/**
	 * <p>Solution 1 : -
	 * Use DFS on all nodes and visit its prerequisite nodes till you find a node with 0 or least
	 * prerequisites.</p>
	 * 
	 * <p>Time  : O(E + V)</p>
	 * <p>Space : O(E + V)</p>
	 * 
	 * @param n
	 * @return void
	 */
	public static void SolutionOne (int n) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
	}
	
	/**
	 * <p>Solution 2 : -</p>
	 * Maintain a list of nodes with no prerequisites and as we add it to our answer list, remove
	 * the dependencies it has. After visiting all nodes we will have the Topological ordering if
	 * it exists.
	 * 
	 *  <p> Time  : O(E + V) </p>
	 *  <p> Space : O(E + V)</p>
	 * 
	 * @param n
	 * @return void
	 */
	public static void SolutionTwo (int n) {
		;
	}
}
