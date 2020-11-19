/*
ID: rishiso1
LANG: JAVA
TASK: wormhole
 */

import java.io.*;
import java.util.*;

public class wormhole {
	
	static int n;
	
	static int[] x = new int[13];
	static int[] y = new int[13];
	static int[] partner = new int[13];
	static int[] next_on_right = new int[13];
	
	static boolean cycle_exists() {
		for (int start = 1; start <= n; start++) {
			int pos = start;
			for (int count = 0; count < n; count++) {
				pos = next_on_right[partner[pos]];
			}
			if (pos != 0) return true;
		}
		
		return false;
	}

	
	static int solve() {
		int i, total = 0;
		for (i = 1; i <= n; i++) {
			if (partner[i] == 0) break;
		}
		
		if (i > n) {
			if (cycle_exists()) return 1; 
			else return 0;
		}
		
		for (int j = i + 1; j <= n; j++) {
			if (partner[j] == 0) {
				partner[i] = j;
				partner[j] = i;
				total += solve();
				partner[i] = partner[j] = 0;
			}
		}
		return total;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("wormhole.out"));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j=1; j <= n; j++) {
				if (x[j] > x[i] && y[i] == y[j]) {
					if (next_on_right[i] == 0 || x[j] - x[i] < x[next_on_right[i]] - x[i]) {
						next_on_right[i] = j;
					}
				}
			}
		}
		
		pw.print(solve());
		pw.print("\n");
		
		pw.close();
		br.close();
	}

}
