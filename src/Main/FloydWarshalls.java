package Main;

import java.io.*;
import java.util.*;

// Algorithm is used to find shortest distance between every pair of vertices in a edge
// weighted directed graph.

public class FloydWarshalls {
	public static void main (String[] args) throws IOException {
		;
	}
	
	public static void Solution (int[][] graph, int n) {
		int[][] ret = FloydWarshalls(graph, n);
	}
	
	public static int[][] FloydWarshalls (int[][] graph, int n) {
		int[][] ret = new int[graph.length][graph[0].length];
		Arrays.fill(ret, Integer.MAX_VALUE);
		ret = graph;
		for (int k = 0 ; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (ret[i][k] + ret[k][j] < ret[i][j]) {
						ret[i][j] = ret[i][k] + ret[k][j];
					}
				}
			}
		}
		return ret;
	}
}
