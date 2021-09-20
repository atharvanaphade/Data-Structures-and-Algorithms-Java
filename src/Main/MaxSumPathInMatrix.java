package Main;

import java.io.*;
import java.util.*;

/**
 * Find the max sum path in the matrix when you can move down or diagonally to the right or left in the matrix.
 * 
 * @author atharvanaphade
 *
 */

public class MaxSumPathInMatrix {
	public static void main (String[] args) throws IOException {
		;
	}
	
	public static void Solution (int[][] mat) {
		int m = mat.length, n = mat[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j > 0 && j < m - 1) {
					mat[i][j] += Math.max (mat[i - 1][j], Math.max(mat[i - 1][j - 1], mat[i - 1][j + 1]));
				} else if (j > 0) {
					mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j - 1]);
				} else if (j < m - 1) {
					mat[i][j] += Math.max(mat[i - 1][j], mat[i - 1][j]);
				}
			}
		}
		int ret = 0;
		for (int i = 0; i < m; i++) {
			ret = Math.max(mat[n - 1][m], ret);
		}
	}
}
