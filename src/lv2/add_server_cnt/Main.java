package lv2.add_server_cnt;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] players = new int[] {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;

        System.out.println(sol.solution(players, m, k));
    }
}
