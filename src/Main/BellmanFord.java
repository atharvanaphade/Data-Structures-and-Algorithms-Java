package Main;

import java.io.*;
import java.util.*;

/**
 * This algorithm finds all the shortest distances from a given src node to all other nodes, this
 * algorithm also works for negative edges. 
 * 
 * Space : O(N)
 * Time : O(N^2)
 * 
 * @author atharvanaphade
 *
 */

public class BellmanFord {
	
	static class Node {
		int u;
		int v;
		int wt;
		public Node(int first, int second, int weight) {
			this.u = first;
			this.v = second;
			this.wt = weight;
		}
	}
	
	public static void main (String[] args) throws IOException {
		Solution();
	}
	
	public static void Solution () {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		ArrayList<Node> edges = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
			edges.add(new Node(u, v, wt));
		}
		int src = sc.nextInt();
		int inf = Integer.MAX_VALUE;
		ArrayList<Integer> dist = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (i == src) {
				dist.add(0);
				continue;
			}
			dist.add(inf);
		}
		for (int i = 1; i <= N - 1; i++) {
			for (Node nn : edges) {
				if (dist.get(nn.u) + nn.wt < dist.get(nn.v)) {
					dist.set(nn.v, dist.get(nn.u) + nn.wt);
				}
			}
		}
		boolean fl = false;
		for (Node nn : edges) {
			if (dist.get(nn.u) + nn.wt < dist.get(nn.v)) {
				System.out.println("Negative Cycle");
				fl = true;
				break;
			}
		}
		if (!fl) {
			for (int i = 0; i < N; i++) {
				System.out.println(i + " " + dist.get(i));
			}
		}
		sc.close();
	}
}
