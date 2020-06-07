/*
ID: rishiso1
LANG: JAVA
PROG: ariprog
*/



import java.io.*;
import java.util.*;

public class ariprog {
	static int n;
	static int m;
	static boolean[] biSquares;
	
	static boolean checkProg(int s, int diff) {
		for (int i = 0; i < n; i++) {
			if (biSquares[s + diff * i] == false) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("ariprog.out"));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		int max = m * m * 2;
		biSquares = new boolean[max + 1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= m; j++) {
				biSquares[i * i + j * j] = true;
			}
		}
		
		ArrayList<int[]> res = new ArrayList<int[]>();
		
		for (int start = 0; start <= max; start++) {
			int maxDiff = (max - start) / (n - 1);
			for (int d = 1; d <= maxDiff; d++) {
				if (checkProg(start, d)) {
					int[] r = new int[2];
					r[0] = start;
					r[1] = d;
					res.add(r);
				}
			}
		}
		
		
		if (res.size() == 0) {
			pw.print("NONE\n");
		} else {
			Collections.sort(res, (a, b) -> Integer.compare(a[1], b[1]));
			for (int[] i: res) {
				pw.print(i[0]);
				pw.print(" ");
				pw.print(i[1]);
				pw.print("\n");
			}
		}		
		br.close();
		pw.close();

	}

}
