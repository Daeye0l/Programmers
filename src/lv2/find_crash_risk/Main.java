package lv2.find_crash_risk;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] points = {{3,2}, {6,4}, {4,7}, {1,4}};
        int[][] points = {{2,2}, {2,3}, {2,7}, {6,6}, {5,2}};
        //int[][] routes = {{4,2}, {1,3}, {2,4}};
        //int[][] routes = {{4,2}, {1,3}, {4,2}, {4,3}};
        int[][] routes = {{2,3,4,5}, {1,3,4,5}};

        System.out.println(solution.solution(points, routes));
    }
}
