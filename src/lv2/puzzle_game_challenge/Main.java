package lv2.puzzle_game_challenge;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] diffs = new int[] {1, 5, 3};
        int[] times = new int[] {2, 4, 7};
        long limit = 30;

        System.out.println(sol.solution(diffs, times , limit));
    }
}
