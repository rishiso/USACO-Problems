/*
ID: rishiso1
LANG: JAVA
PROG: numtri
*/

import java.io.*;
import java.util.*;

public class numtri {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("numtri.out"));
		
		int r = Integer.parseInt(br.readLine());
		int[][] pyramid = new int[r][r];
		
		StringTokenizer st;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				pyramid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	
		for (int i = r - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				pyramid[i][j] += Math.max(pyramid[i + 1][j], pyramid[i + 1][j + 1]);
			}
		}
		
		pw.println(pyramid[0][0]);
		pw.close();
	}

}
