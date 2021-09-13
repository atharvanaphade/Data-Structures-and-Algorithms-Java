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
	public static void main (String[] args) throws IOException {
		;
	}
	
	/**
	 * <p>Solution 1 : -
	 * Use DFS on all nodes and visit its prerequisite nodes till you find a node with 0 or least
	 * prerequisites.</p>
	 * 
	 * <p>Time  s: O(E + V)</p>
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
