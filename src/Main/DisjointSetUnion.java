package Main;

import java.util.*;

public class DisjointSetUnion {
	class DSU {
		private ArrayList<Integer> rank;
		private ArrayList<Integer> parent;
		
		public DSU() {
			rank = new ArrayList<>();
			parent = new ArrayList<>();
		}
		
		public int findPar(int node) {
			if (node == parent.get(node)) {
				return node;
			}
			return parent.set(node, findPar(node));
		}
		
		public void union(int u, int v) {
			u = findPar(u);
			v = findPar(v);
			
			if (rank.get(u) < rank.get(v)) {
				parent.set(u, v);
			} else if (rank.get(u) > rank.get(v)) {
				parent.set(v, u);
			} else {
				parent.set(v, u);
				parent.set(u, parent.get(u) + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		;
	}
}
