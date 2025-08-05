package lv2.perpect_crime;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;

        // dp[i][j] = i번째 물건까지 확인 했을 때 B가 훔치고 생긴 흔적이 j개일 때 A가 훔치고 생긴 흔적의 최소 개수
        int[][] dp = new int[info.length+1][m];
        for(int i = 0; i <= info.length; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = 120;
            }
        }

        dp[0][0] = 0;
        for(int i = 1; i <= info.length; i++) {
            int a = info[i-1][0]; // i번째 물건을 A가 훔칠 때 생기는 흔적의 개수
            int b = info[i-1][1]; // i번째 물건을 B가 훔칠 때 생기는 흔적의 개수

            for(int j = 0; j < m; j++) {
                // i번째 물건을 A가 훔치는 경우
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                // i번째 물건을 B가 훔치는 경우
                if(j+b < m) dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
            }
        }

        // 모든 물건을 훔친 경우의 값들 중에서 가장 작은 값 찾기
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[info.length][i]);
        }

        return answer < n ? answer : -1;
    }
}
