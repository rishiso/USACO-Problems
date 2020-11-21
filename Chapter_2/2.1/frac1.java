/*
ID: rishiso1
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.*;

public class frac1 {
	
	static boolean isSimplified(int[] fraction) {
		for(int i = 2; i <= fraction[0]; i++) {
			if (fraction[0] % i == 0 && fraction[1] % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("frac1.out"));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> fractions = new ArrayList<int[]>();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				int[] f = new int[] {j, i};
				if (isSimplified(f)) {
					fractions.add(f);
				}
			}
		}
		
		Collections.sort(fractions, 
				(a, b) -> (double) a[0] / a[1] > (double) b[0] / b[1] ? 1 : (double) b[0] / b[1] > (double) a[0] / a[1] ? -1 : 0);
		
		pw.println("0/1");
		for(int[] f : fractions) {
			String n = Integer.toString(f[0]);
			String d = Integer.toString(f[1]);
			pw.println(String.join("", n, "/", d));
		}
		
		br.close();
		pw.close();
	}

}
