package lv2.perpect_crime;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 4;
        int m = 4;
        System.out.println(sol.solution(info, n, m));
    }
}
