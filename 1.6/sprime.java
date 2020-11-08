/*
ID: rishiso1
LANG: JAVA
TASK: sprime
 */

import java.io.*;
import java.util.Arrays;

public class sprime {
	
	static PrintWriter pw;
	static int[] primes = new int[] {1, 3, 7, 9};
	
	static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		
		if (n % 2 == 0 && n != 2) {
			return false;
		}
		
		for(int i = 3; i * i < n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	static void solve(int level, int[] n) {
		
		if (level == n.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n.length; i++) {
				sb.append(n[i]);
			}
			
			if (isPrime(Integer.parseInt(sb.toString()))) {
				pw.print(sb.toString());
				pw.println();
			}
			
		} else {
		
			for(int x: primes) {
				n[level] = x;
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i <= level; i++) {
					sb.append(n[i]);
				}
				
				if (isPrime(Integer.parseInt(sb.toString()))) {
					solve(level + 1, n);
				}
			}
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
		pw = new PrintWriter(new FileWriter("sprime.out"));
		
		int l = Integer.parseInt(br.readLine());
		int[] a = new int[l];
		a[0] = 2;
		solve(1, a);
		a[0] = 3;
		solve(1, a);
		a[0] = 5;
		solve(1, a);
		a[0] = 7;
		solve(1, a);
		
		br.close();
		pw.close();
	}

}
