package lv2.도넛과_막대_그래프;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] edges = {{2,3}, {4,3}, {1,1}, {2,1}};
		int[] answer = sol.solution(edges);
		System.out.print(answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3]);
	}
}