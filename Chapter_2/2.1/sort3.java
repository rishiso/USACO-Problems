/*
ID: rishiso1
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.*;

public class sort3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("sort3.out"));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int[] sortedNums = nums.clone();
		Arrays.sort(sortedNums);
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(nums[i] != sortedNums[i] && nums[j] != sortedNums[j] && nums[i] == sortedNums[j] && nums[j] == sortedNums[i]) {
					int a = nums[i];
					nums[i] = nums[j];
					nums[j] = a;
					count++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(nums[i] != sortedNums[i] && nums[j] != sortedNums[j] && nums[i] == sortedNums[j]) {
					int a = nums[i];
					nums[i] = nums[j];
					nums[j] = a;
					count++;
				}
			}
		}
		
		pw.println(count);
		
		br.close();
		pw.close();
	}

}
