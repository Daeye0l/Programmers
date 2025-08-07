package lv2.secret_code_decoding;

import java.util.*;

public class Solution {
    static int answer;

    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        dfs(0, 1, n, new ArrayList<>(), q, ans);
        return answer;
    }

    private static void dfs(int depth, int idx, int n, List<Integer> temp, int[][] q, int[] ans) {
        // 비밀 코드는 5자리
        if(depth == 5) {
            if(isPossible(temp, q, ans)) answer++;
            return;
        }

        // 비밀 코드는 1~n까지 서로 다른 정수의 오름차순으로 이루어짐
        for(int i = idx; i <= n; i++) {
            temp.add(i);
            dfs(depth+1, i+1, n, temp, q, ans);
            temp.remove(temp.size()-1);
        }
    }

    private static boolean isPossible(List<Integer> temp, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int[] question = q[i];
            int cnt = 0;

            for (int j = 0; j < question.length; j++) {
                if(temp.contains(question[j])) {
                    cnt++;
                }
            }

            // dfs로 만든 비밀 코드와 입력한 정수에 대한 시스템 응답이 1개라도 다르다면 답이 될 수 없음
            if(cnt != ans[i]) return false;
        }
        return true;
    }
}
