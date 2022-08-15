package Main;

import java.io.*;

public class MergeSort {
	public static void main(String[] args) throws IOException {
		int array[] = { 8, 5, 8, 6, 2, 3, 1 };
		int aux[] = array;
		Helper(array, 0, 6, aux);
		for (Object var : array) {
			System.out.print(var + " ");
		}
	}
	
	private static void Helper(int mainArray[], int startIdx, int endIdx, int auxilliaryArray[]) {
		if (startIdx == endIdx) {
			return;
		}
		
		int middleIdx = (startIdx + endIdx) / 2;
		Helper(auxilliaryArray, startIdx, middleIdx, mainArray);
		Helper(auxilliaryArray, middleIdx + 1, endIdx, mainArray);
		doMerge(mainArray, startIdx, middleIdx, endIdx, auxilliaryArray);
	}
	
	private static void doMerge(int mainArray[], int startIdx, int middleIdx, int endIdx, int auxilliaryArray[]) {
		int k = startIdx, i = startIdx, j = middleIdx + 1;
		
		while (i <= middleIdx && j <= endIdx) {
			if (auxilliaryArray[i] <= auxilliaryArray[j]) {
				mainArray[k] = auxilliaryArray[i];
				i += 1;
			} else {
				mainArray[k] = auxilliaryArray[j];
				j += 1;
			}
			k += 1;
		}
		
		while (i <= middleIdx) {
			mainArray[k] = auxilliaryArray[i];
			i += 1;
			k += 1;
		}
		
		while (j <= endIdx) {
			mainArray[k] = auxilliaryArray[j];
			j += 1;
			k += 1;
		}
		
		for (Object var : mainArray) {
			System.out.print(var + " ");
		}
		System.out.println();
	}
}
