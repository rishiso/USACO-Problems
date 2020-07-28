/*
ID: rishiso1
LANG: JAVA
PROG: milk3
*/

import java.io.*;
import java.util.*;

public class milk3 {
	
	static int aMax, bMax, cMax;
	static int[] solutions = new int[21];
	static int[][][] usedStates = new int[21][21][21];
	
	static void dfs(int a, int b, int c) {
		if (usedStates[a][b][c] == 0) {
			usedStates[a][b][c] = 1;
			if (a == 0) solutions[c] = 1;
			
			int transfer;
			
			//1 -> 2
			transfer = Math.min(bMax - b, a);
			dfs(a - transfer, b + transfer, c);
			
			//1 -> 3
			transfer = Math.min(cMax - c, a);
			dfs(a - transfer, b, c + transfer);
			
			//2 -> 1
			transfer = Math.min(aMax - a, b);
			dfs(a + transfer, b - transfer, c);
			
			//2 -> 3
			transfer = Math.min(cMax - c, b);
			dfs(a, b - transfer, c + transfer);
			
			//3 -> 1
			transfer = Math.min(aMax - a, c);
			dfs(a + transfer, b, c - transfer);
			
			//3 -> 2
			transfer = Math.min(bMax - b, c);
			dfs(a, b + transfer, c - transfer);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("milk3.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		aMax = Integer.parseInt(st.nextToken());
		bMax = Integer.parseInt(st.nextToken());
		cMax = Integer.parseInt(st.nextToken());
		solutions[cMax] = 1;
		
		dfs(0, 0, cMax);
		
		ArrayList<String> output = new ArrayList<>();
		for(int i = 0; i < 21; i++) {
			if (solutions[i] == 1) {
				output.add(Integer.toString(i));
			}
		}
		pw.print(String.join(" ", output));
		pw.println();
		pw.close();
	}

}
