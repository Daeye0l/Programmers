package lv2.석유시추;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[][] land = getLand(2);
		System.out.println(sol.solution(land));
	}
	
	private static int[][] getLand(int num) {
		int[][] land = null;
		if(num == 1) {
			land = new int[][] {{0, 0, 0, 1, 1, 1, 0, 0},
								{0, 0, 0, 0, 1, 1, 0, 0},
								{1, 1, 0, 0, 0, 1, 1, 0},
								{1, 1, 1, 0, 0, 0, 0, 0},
								{1, 1, 1, 0, 0, 0, 1, 1}};
		}
		else if(num == 2) {
			land = new int[][] {{1, 0, 1, 0, 1, 1}, 
								{1, 0, 1, 0, 0, 0},
								{1, 0, 1, 0, 0, 1},
								{1, 0, 0, 1, 0, 0},
								{1, 0, 0, 1, 0, 1},
								{1, 0, 0, 0, 0, 0},
								{1, 1, 1, 1, 1, 1}};
		}
		return land;
	}
}