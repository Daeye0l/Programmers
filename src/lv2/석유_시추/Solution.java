package lv2.석유_시추;

import java.util.*;

class Solution {
	static boolean[][] visited;
	static int[] colSum;
	static int cnt = 0;
	static int[][] coords = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
       
        visited = new boolean[n][m];
        colSum = new int[m]; // 각 열에 시추관을 삽입했을 때 얻을 수 있는 석유의 양
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(land[j][i] == 1 && !visited[j][i]) {
        			bfs(land, n, m, new int[] {j, i});
        		}
        	}
        }
        
        for(int i = 0; i < colSum.length; i++) {
        	//System.out.println(i+1 + "열에 시추관을 삽입할 때 얻는 석유의 양: " + colSum[i]);
        	answer = Math.max(answer, colSum[i]);
        }
        
        return answer;
    }
    
    private static void bfs(int[][] land, int n, int m, int[] start) {
    	int cnt = 0; // start 위치에서부터 발견된 유전의 크기
    	Set<Integer> set = new HashSet<>(); // 해당 유전이 걸쳐있는 모든 열
    	
    	Queue<int[]> queue = new LinkedList<>();
    	visited[start[0]][start[1]] = true;
    	queue.offer(start);
    	
    	while(!queue.isEmpty()) {
    		int[] curr = queue.poll();
    		cnt++;
    		set.add(curr[1]);
    		
    		for(int[] coord : coords) {
    			int nx = curr[0] + coord[0];
    			int ny = curr[1] + coord[1];
    			
    			if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
    				if(land[nx][ny] == 1 && !visited[nx][ny]) {
    					visited[nx][ny] = true;
    					queue.offer(new int[] {nx, ny});
    				}
    			}
    		}
    	}
    	
    	for(int col : set) {
    		colSum[col] += cnt;
    	}
    }
}