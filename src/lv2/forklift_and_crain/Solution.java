package lv2.forklift_and_crain;

import java.util.*;

public class Solution {
    static int n, m, answer;
    static int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static char[][] containers;

    public int solution(String[] storage, String[] requests) {
        answer = storage.length * storage[0].length();
        n = storage.length+2;
        m = storage[0].length()+2;

        // 창고의 컨테이너들을 배열에 저장
        containers = new char[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(containers[i], '0');
        }
        for(int i = 1; i <= storage.length; i++) {
            for(int j = 1; j <= storage[0].length(); j++) {
                containers[i][j] = storage[i-1].charAt(j-1);
            }
        }

        // 요청을 수행
        for(String request : requests) {
            char target = request.charAt(0);
            if(request.length() == 1) forkliftRemove(target);
            else crainRemove(target);
        }

        return answer;
    }

    private static void forkliftRemove(char target) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        que.offer(new int[] {0, 0});
        visited[0][0] = true;
        while(!que.isEmpty()) {
            int[] curr = que.poll();

            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];

                if (nx >= n || nx < 0 || ny >= m || ny < 0 || visited[nx][ny]) continue;

                if(containers[nx][ny] == '0') {
                    que.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
                else if(containers[nx][ny] == target) {
                    answer--;
                    containers[nx][ny] = '0';
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void crainRemove(char target) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(containers[i][j] == target) {
                    containers[i][j] = '0';
                    answer--;
                }
            }
        }
    }
}
