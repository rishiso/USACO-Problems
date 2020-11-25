/*
ID: rishiso1
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming {
	static int[] solutions;
	static int current;
	static int D;
	
	static int hammingDistance(int a, int b) { 
	    int x = a ^ b; 
	    int setBits = 0; 
	  
	    while (x > 0)  
	    { 
	        setBits += x & 1; 
	        x >>= 1; 
	    } 
	  
	    return setBits;
	}
	
	static boolean isValid(int n) {
		for(int i = 0; i < current; i++) {
			if (hammingDistance(n, solutions[i]) < D) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("hamming.out"));
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(s.nextToken());
		int B = Integer.parseInt(s.nextToken());
		D = Integer.parseInt(s.nextToken());
		
		solutions = new int[N];
		current = 1;
		
		for(int i = 0; i <= Math.pow(2, B); i++) {
			if (current == N) {
				break;
			}
			
			if (isValid(i)) {
				solutions[current] = i;
				current++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			pw.print(solutions[i]);
			if (i > 0 && i % 10 == 9 && i < N - 1) {
				pw.println();
			} else if (i < N - 1) {
				pw.print(" ");
			}
		}
		pw.println();
		
		br.close();
		pw.close();
	}

}
