package lv2.선인장_숨기기;

import java.util.*;

class Solution {
	static int INF = 500001;
	
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = new int[2];
        
        int[][] grid = new int[m][n];
        for(int[] arr : grid) {
        	Arrays.fill(arr, INF);
        }
        
        // 비가 내리는 칸에 비의 인덱스를 저장
        int idx = 1;
        for(int[] drop : drops) {
        	grid[drop[0]][drop[1]] = idx++;
        }
        
        // 가로 방향과 세로 방향으로 슬라이딩 윈도우를 2번 적용
        int[][] rowMin = new int[m][n-w+1];
        for(int i = 0; i < m; i++) {
        	Deque<Integer> candidates = new ArrayDeque<>();
        	for(int j = 0; j < n; j++) {
        		// 윈도우 크기를 벗어나는 인덱스 우선 제거
        		if(!candidates.isEmpty() && candidates.peekFirst() < j-w+1) {
        			candidates.pollFirst();
        		}
        		// 새로 윈도우 범위에 들어온 인덱스의 격자 값보다 값이 큰 인덱스는 제거
        		while(!candidates.isEmpty() && grid[i][candidates.peekLast()] >= grid[i][j]) {
        			candidates.pollLast();
        		}
        		candidates.offer(j);
        		// 윈도우 사이즈가 완성되면 최솟값 저장하기
        		if(j-w+1>= 0) {
        			rowMin[i][j-w+1] = grid[i][candidates.peekFirst()];
        		}
        	}
        }
        
        int[][] colMin = new int[m-h+1][n-w+1];
        for(int j = 0; j < n-w+1; j++) {
        	Deque<Integer> candidates = new ArrayDeque<>();
        	for(int i = 0; i < m; i++) {
        		if(!candidates.isEmpty() && candidates.peekFirst() < i-h+1) {
        			candidates.pollFirst();
        		}
        		while(!candidates.isEmpty() && rowMin[candidates.peekLast()][j] >= rowMin[i][j]) {
        			candidates.pollLast();
        		}
        		candidates.offer(i);
        		if(i-h+1 >= 0) {
        			colMin[i-h+1][j] = rowMin[candidates.peekFirst()][j];
        		}
        	}
        }
        
        int maxDropIdx = 0;
        for(int i = 0; i < m-h+1; i++) {
        	for(int j = 0; j < n-w+1; j++) {
        		// 비를 맞지 않을 수 있는 위치가 나오면 바로 반환
        		if(colMin[i][j] == INF) {
        			answer[0] = i;
        			answer[1] = j;
        			return answer;
        		}
        		// 비를 맞아야 한다면 가장 늦게 맞기 위한 위치를 저장
        		if(maxDropIdx < colMin[i][j]) {
        			maxDropIdx = colMin[i][j];
        			answer[0] = i;
        			answer[1] = j;
        		}
        	}
        }
        
        return answer;
    }	
}