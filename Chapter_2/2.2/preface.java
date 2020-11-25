/*
ID: rishiso1
LANG: JAVA
TASK: preface
*/

import java.io.*;

public class preface {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("preface.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("preface.out"));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] letterCounts = new int[7];
		
		for (int i = 1; i <= N; i++) {
			int x = i;
			if (x >= 1000) {
				int numFit = x / 1000;
				letterCounts[6] += numFit;
				x -= 1000 * numFit;
			}
			
			if (x >= 900) {
				letterCounts[4]++;
				letterCounts[6]++;
				x -= 900;
			}
			
			if (x >= 500) {
				letterCounts[5]++;
				x -= 500;
			}
			
			if (x >= 400) {
				letterCounts[4]++;
				letterCounts[5]++;
				x -= 400;
			}
			
			if (x >= 100) {
				int numFit = x / 100;
				letterCounts[4] += numFit;
				x -= 100 * numFit;
			}
			
			if (x >= 90) {
				letterCounts[4]++;
				letterCounts[2]++;
				x -= 90;
			}
			
			if (x >= 50) {
				letterCounts[3]++;
				x -= 50;
			}
			
			if (x >= 40) {
				letterCounts[3]++;
				letterCounts[2]++;
				x -= 40;
			}
			
			if (x >= 10) {
				int numFit = x / 10;
				letterCounts[2] += numFit;
				x -= 10 * numFit;
			}
			
			if (x >= 9) {
				letterCounts[2]++;
				letterCounts[0]++;
				x -= 9;
			}
			
			if (x >= 5) {
				letterCounts[1]++;
				x -= 5;
			}
			
			if (x >= 4) {
				letterCounts[1]++;
				letterCounts[0]++;
				x -= 4;
			}
			
			if (x >= 1) {
				int numFit = x;
				letterCounts[0] += numFit;
				x -= numFit;
			}
						
		}
				
		String[] numerals = new String[] {"I", "V", "X", "L", "C", "D", "M"};
		
		for(int i = 0; i < 7; i++) {
			if (letterCounts[i] > 0) {
				pw.print(numerals[i]);
				pw.print(" ");
				pw.print(letterCounts[i]);
				pw.println();
			}
		}
		
		br.close();
		pw.close();

	}

}
