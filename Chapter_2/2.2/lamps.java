/*
ID: rishiso1
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class lamps {
	
	static ArrayList<int[]> flips = new ArrayList<int[]>();
	
	static ArrayList<Integer> on;
	static ArrayList<Integer> off;
	
	static void permutate(int[] combo, int level, int end) {
		if (level == end) {
			flips.add(combo);
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			int[] newCombo = combo.clone();
			newCombo[level] = i;
			permutate(newCombo, level + 1, end);
		}
	}
	
	static int[] flipLights(int N, int[] f) {
		int[] lightStates = new int[N];
        Arrays.fill(lightStates, 1);
        
        for(int i: f) {
        	if (i == 1) {
        		for(int j = 0; j < lightStates.length; j++) {
        			lightStates[j] *= -1;
        		}
        	} else if (i == 2) {
        		for(int j = 0; j < lightStates.length; j++) {
        			if (j % 2 == 0) lightStates[j] *= -1;
        		}
        	} else if (i == 3) {
        		for(int j = 0; j < lightStates.length; j++) {
        			if (j % 2 == 1) lightStates[j] *= -1;
        		}
        	} else if (i == 4) {
        		for(int j = 0; j < lightStates.length; j++) {
        			if (j % 3 == 0) lightStates[j] *= -1;
        		}
        	}
        }
        return lightStates;
	}
	
	static boolean isValid(int[] lightStates) {
		for(int x: on) {
			if (lightStates[x] == -1) return false;
		}
		
		for(int x: off) {
			if (lightStates[x] == 1) return false;
		}
		
		return true;
	}
	
	static long binarize(List<Integer> l) {
		long s = 0;
		int count = (l.size() - 1) / 2;
		for(Integer i: l) {
			s += i * Math.pow(2, count);
			count--;
		}
		return s;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        
        int N = Integer.parseInt(br.readLine());
        int C = Math.min(Integer.parseInt(br.readLine()), 4);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        on = new ArrayList<Integer>();
        for(int i = 0; i < st.countTokens() - 1; i++) {
        	on.add(Integer.parseInt(st.nextToken()) - 1);
        }
        
        st = new StringTokenizer(br.readLine());
        off = new ArrayList<Integer>();
        for(int i = 0; i < st.countTokens() - 1; i++) {
        	off.add(Integer.parseInt(st.nextToken()) - 1);
        }
        
        permutate(new int[C], 0, C);
        boolean possible = false;
        
        HashSet<List<Integer>> solutions = new HashSet<List<Integer>>();
        
        for(int[] e: flips) {
        	int[] ls = flipLights(N, e);
        	
        	if (isValid(ls)) {
        		List<Integer> lightStates = Arrays.stream(ls).boxed().collect(Collectors.toList());
        		possible = true;
        		solutions.add(lightStates);
        	}	
        }
        
        List<List<Integer>> formattedSolutions = new ArrayList<List<Integer>>();
        formattedSolutions.addAll(solutions);
        
        Collections.sort(formattedSolutions, 
        		Comparator.comparingLong(a -> binarize(a)));
        
        for(List<Integer> l: formattedSolutions) {
        	System.out.println(binarize(l));
        	for(Integer e: l) {
        		if (e == -1) pw.print(0);
        		else pw.print(1);
        	}
        	pw.println();
        }
        
        if (!possible) pw.println("IMPOSSIBLE");
        
        br.close();
        pw.close();
	}

}
