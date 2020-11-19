/*
ID: rishiso1
LANG: JAVA
TASK: castle
*/

import java.io.*;

public class castle {
	static int C;
	static int R;
	
	static int[] south;
	static int[] east;
	static int[] north;
	static int[] west;
	
	static int[] components;
	static int currentComponent = 0;
	
	static void findRooms(int currentRoom) {
		components[currentRoom] = currentComponent;
		
		if (south[currentRoom] == 0 && components[currentRoom + C] == 0) {
			findRooms(currentRoom + C);
		}
		if (east[currentRoom] == 0 && components[currentRoom + 1] == 0) {
			findRooms(currentRoom + 1);
		}
		if (north[currentRoom] == 0 && components[currentRoom - C] == 0) {
			findRooms(currentRoom - C);
		}
		if (west[currentRoom] == 0 && components[currentRoom - 1] == 0) {
			findRooms(currentRoom - 1);
		}
		
	}
	
	static int nextRoom() {
		for(int i = 0; i < components.length; i++) {
			if (components[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	
	static int findLargestRoom() {
		int largestRoom = 0;
		for(int i = 1; i <= currentComponent; i++) {
			int currentCount = 0;
			for(int j: components) {
				if (i == j) currentCount += 1;
			}
			largestRoom = Math.max(largestRoom, currentCount);
		}
		return largestRoom;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("castle.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("castle.out"));
		
		String[] s = br.readLine().split(" ");
		C = Integer.parseInt(s[0]);
		R = Integer.parseInt(s[1]);
		
		south = new int[C * R];
		east = new int[C * R];
		north = new int[C * R];
		west = new int[C * R];
		
		components = new int[C * R];
		
		for(int i = 0; i < R; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < C; j++) {
				int p = Integer.parseInt(s[j]);
				if (p >= 8) {
					south[i * C + j] = 1;
					p -= 8;
				}
				if (p >= 4) {
					east[i * C + j] = 1;
					p -= 4;
				}
				if (p >= 2) {
					north[i * C + j] = 1;
					p -= 2;
				}
				if (p >= 1) {
					west[i * C + j] = 1;
					p -= 1;
				}
			}
		}
		
		
		
		while (nextRoom() != -1) {
			currentComponent += 1;
			findRooms(nextRoom());
		}
		
		pw.println(currentComponent);
		pw.println(findLargestRoom());
		
		int maximumRoom = 0;
		int wallLocation = 0;
		String direction = "E";
		for(int i = 0; i < C; i++) {
			for (int j = R - 1; j >= 0; j--) {
				int w = C * j + i;
			
				if (north[w] == 1 && w >= C) {
					int count = 0;
					for(int x: components) {
						if (x == components[w] || x == components[w - C]) count += 1;
					}
					if (count > maximumRoom) {
						maximumRoom = count;
						wallLocation = w;
						direction = "N";
					}
				}
				if (south[w] == 1 && w < south.length - C) {
					int count = 0;
					for(int x: components) {
						if (x == components[w] || x == components[w + C]) count += 1;
					}
					if (count > maximumRoom) {
						maximumRoom = count;
						wallLocation = w;
						direction = "S";
					}
				}
				if (east[w] == 1 && w % C != C - 1) {
					int count = 0;
					for(int x: components) {
						if (x == components[w] || x == components[w + 1]) count += 1;
					}
					if (count > maximumRoom) {
						maximumRoom = count;
						wallLocation = w;
						direction = "E";
					}
				}
				if (west[w] == 1 && w % C != 0) {
					int count = 0;
					for(int x: components) {
						if (x == components[w] || x == components[w - 1]) count += 1;
					}
					if (count > maximumRoom) {
						maximumRoom = count;
						wallLocation = w;
						direction = "W";
					}
				}
			}
		}
		
		pw.println(maximumRoom);
		pw.println(String.join(" ", Integer.toString(wallLocation / C + 1), Integer.toString(wallLocation % C + 1), direction));
		System.out.println(String.join(" ", Integer.toString(wallLocation / C + 1), Integer.toString(wallLocation % C + 1), direction));
		
		br.close();
		pw.close();
	}

}
