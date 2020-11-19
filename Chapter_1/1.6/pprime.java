/*
ID: rishiso1
LANG: JAVA
TASK: pprime
*/

import java.io.*;

public class pprime {
	
	static int a;
	static int b;
	
	static boolean isValid(int n) {
		if (n > b || n < a) {
			return false;
		}
		
		if (n == 1) {
			return false;
		}
		
		if (n % 2 == 0 && n != 2) {
			return false;
		}
		
		for(int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("pprime.out"));
		
		String[] in = (br.readLine()).split(" ");
		a = Integer.parseInt(in[0]);
		b = Integer.parseInt(in[1]);
		System.out.println(a);
		System.out.println(b);
		
		int a_digit = (int) Math.log10(a) + 1;
		int b_digit = (int) Math.log10(b) + 1;
		
		for (int i = a_digit; i <= b_digit; i++) {
			
			if (i % 2 == 1) {
				for (int j = (int) Math.pow(10, (i/2)); j < (int) Math.pow(10, (i/2) + 1); j++) {
					String s = Integer.toString(j);
					String e = s.substring(0, s.length() - 1);
					s = String.join("", s, new StringBuilder(e).reverse().toString());
					if (isValid(Integer.parseInt(s))) {
						pw.println(s);
					}
				}
			} else {
				
				for (int j = (int) Math.pow(10, (i/2) - 1); j < (int) Math.pow(10, i/2); j++) {
					String s = Integer.toString(j);
					s = String.join("", s, new StringBuilder(s).reverse().toString());
					if (isValid(Integer.parseInt(s))) {
						pw.println(s);
					}
				}
			}
		}
		
		br.close();
		pw.close();
	}

}
