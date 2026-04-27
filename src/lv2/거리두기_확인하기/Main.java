package lv2.거리두기_확인하기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
							 {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
							 {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							 {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							 {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		int[] answer = sol.solution(places);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}