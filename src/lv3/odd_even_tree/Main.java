package lv3.odd_even_tree;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] answer = sol.solution(new int[] {11, 9, 3, 2, 4, 6}, new int[][] {{9, 11}, {2, 3}, {6, 3}, {3, 4}});
        System.out.println(answer[0] + " " + answer[1]);
    }
}
