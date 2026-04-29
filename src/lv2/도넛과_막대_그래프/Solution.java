package lv2.도넛과_막대_그래프;

import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        // 간선 정보를 가지고 indegree, outdegree 구하기 
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        Set<Integer> vertex = new HashSet<>();
        
        for(int[] edge : edges) {
        	indegree.put(edge[1], indegree.getOrDefault(edge[1], 0)+1);
        	outdegree.put(edge[0], outdegree.getOrDefault(edge[0], 0)+1);
        	vertex.add(edge[0]);
        	vertex.add(edge[1]);
        }
        
        for(int v : vertex) {
        	int in = indegree.getOrDefault(v, 0);
        	int out = outdegree.getOrDefault(v, 0);
        	
        	// 1. 각 모양 그래프들을 연결하는 하나의 정점 구하기
            // indegree가 없어야 하며 outdegree가 2이상이어야 함
        	if(in == 0 && out >= 2) {
        		answer[0] = v;
        	}
        	// 2. 막대 모양 그래프인 경우
        	// outdegree가 없는 정점을 잡고 아래로 세운다고 생각하면 편함
        	else if(out == 0) {
        		answer[2]++;
        	}
        	// 3. 8자 모양 그래프인 경우
        	// indegree와 outdegree가 2인 정점이 있는 경우
        	else if(in >= 2 && out >= 2) {
        		answer[3]++;
        	}
        }
        
        // 4. 도넛 모양 그래프인 경우
        // 막대, 8자 모양 그래프를 제외한 나머지 개수
        answer[1] = outdegree.get(answer[0]) - (answer[2]+answer[3]);
        
        return answer;
    }
}