/*
ID: rishiso1
LANG: JAVA
TASK: runround
*/

import java.io.*;
import java.util.*;

public class runround {
	
	static int M;
	static ArrayList<String[]> combos = new ArrayList<String[]>();
	
	static boolean isRunround(String[] digits) {
		int numDigits = digits.length;
		int[] seen = new int[numDigits];
		
		int currentSpot = 0;
		
		for (int i = 0; i < numDigits - 1; i++) {
			seen[currentSpot] = 1;
			currentSpot = (currentSpot + Integer.parseInt(digits[currentSpot])) % numDigits;
			
			if (seen[currentSpot] == 1) {
				return false;
			}
		}
		
		currentSpot = (currentSpot + Integer.parseInt(digits[currentSpot])) % numDigits;
		if (currentSpot != 0) {
			return false;
		}
		
		return true;
	}
	
	static void permutate(String[] combo, int[] seen, int level, int end) {
		if (level == end) {
			combos.add(combo);
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			if (seen[i - 1] == 0) {
				String[] newCombo = combo.clone();
				newCombo[level] = Integer.toString(i);
				int[] newSeen = seen.clone();
				newSeen[i - 1] = 1;
				permutate(newCombo, newSeen, level + 1, end);
			}
		}
	}
	

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("runround.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        
        M = Integer.parseInt(br.readLine());
        
        int digits =(int) Math.ceil(Math.log10(M));
        String[] startingCombo = new String[digits];
        int[] seen = new int[9];
        
        permutate(startingCombo, seen, 0, digits);
         
        outerloop:
        while(true) {
        	for(String[] e: combos) {
        		int s = Integer.parseInt(String.join("", e));
        		if (s > M && isRunround(e)) {
        			pw.println(s);
        			break outerloop;
        		}
        	}
	        digits++;
	        startingCombo = new String[digits];
	        seen = new int[9];
	        combos.clear();
	        
	        permutate(startingCombo, seen, 0, digits);
        }
                
        br.close();
        pw.close();
                
	}

}
