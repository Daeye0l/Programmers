package lv2.secret_code_decoding;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10;
        int[][] q = new int[][] {{1,2,3,4,5}, {6,7,8,9,10}, {3,7,8,9,10}, {2,5,7,9,10}, {3,4,5,6,7}};
        int[] ans = new int[] {2, 3, 4, 3, 3};

        System.out.println(sol.solution(n, q, ans));
    }
}
