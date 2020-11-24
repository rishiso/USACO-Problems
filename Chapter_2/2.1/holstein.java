/*
ID: rishiso1
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.*;

public class holstein {
	
	static int G;
	static int[] reqs;
	
	static ArrayList<ArrayList<Integer>> findCombos(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 0, item, result);
		return result;	
	}
	
	static void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
	 
		for (int i = start; i < n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}
	
	static boolean meetsStandards(int[] vals) {
		for(int i = 0; i < vals.length; i++) {
			if (vals[i] < reqs[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("holstein.out"));
		
		int V = Integer.parseInt(br.readLine());
		
		reqs = new int[V];
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		for(int i = 0; i < V; i++) {
			reqs[i] = Integer.parseInt(s.nextToken());
		}
		
		G = Integer.parseInt(br.readLine());
		
		int[][] feeds = new int[G][V];
		
		for(int i = 0; i < G; i++) {
			s = new StringTokenizer(br.readLine());
			for(int j = 0; j < V; j++) {
				feeds[i][j] = Integer.parseInt(s.nextToken());
			}
		}
		
		outerloop:
		for(int i = 1; i <= G; i++) {
			for(ArrayList<Integer> combo: findCombos(G, i)) {
				int[] a = new int[V];
				for(int f: combo) {
					for(int j = 0; j < V; j++) {
						a[j] += feeds[f][j];
					}
				}
				if (meetsStandards(a)) {
					pw.print(combo.size());
					for(int f: combo) {
						pw.print(" ");
						pw.print(f + 1);
					}
					pw.println("");
					break outerloop;
				}
			}	
		}
		
		

		br.close();
		pw.close();

	}

}
