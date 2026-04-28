package lv2.선인장_숨기기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int m = 4; int n = 6; int h = 3; int w = 4;
		int[][] drops = {{1, 2}};
		int[] result = sol.solution(m, n, h, w, drops);
		System.out.print(result[0] + " " + result[1]);
	}
}