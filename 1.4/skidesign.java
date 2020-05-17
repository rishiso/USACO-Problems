/*
ID: rishiso1
LANG: JAVA
TASK: skidesign
 */
import java.io.*;

public class skidesign {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("skidesign.out"));
		
		int n = Integer.parseInt(br.readLine());
		int[] hills = new int[n];
		
		for(int i = 0; i < n; i++) {
			hills[i] = Integer.parseInt(br.readLine());
		}
		
		int minCost = (int) Math.pow(10, 99);
		int cost;
		int diff;
		
		for (int i = 0; i < 83; i++) {
			cost = 0;
			for (int j = 0; j < n; j++) {
				if (hills[j] < i) {
					diff = i - hills[j];
					cost += diff * diff;
				} else if (hills[j] > i + 17) {
					diff = hills[j] - (i + 17);
					cost += diff * diff;
				}
			}
			minCost = Math.min(cost, minCost);
		}
		
		pw.print(minCost);
		pw.print("\n");
		
		
		pw.close();
		br.close();
	}

}
