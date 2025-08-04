package lv3.odd_even_tree;

import java.util.*;

public class Solution {
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];

        // 각 노드의 인접리스트와 방문 여부를 초기화
        for(int i = 0; i < nodes.length; i++) {
            adjList.put(nodes[i], new ArrayList<>());
            visited.put(nodes[i], false);
        }

        // 간선 정보를 바탕으로 인접 리스트 완성
        for(int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for(int node : nodes) {
            if(visited.get(node)) continue;

            int oddEvenCnt = 0;
            int reverseOddEvenCnt = 0;

            Queue<Integer> que = new ArrayDeque<>();
            que.offer(node);
            visited.put(node, true);

            // bfs로 서로 같은 그룹의 노드들끼리 확인
            while(!que.isEmpty()) {
                int curr = que.poll();

                // 현재 노드가 홀짝 트리의 루트가 될 수 있는지 확인
                if(curr%2 == adjList.get(curr).size()%2) oddEvenCnt++;
                // 현재 노드가 역홀짝 트리의 루트가 될 수 있는지 확인
                else reverseOddEvenCnt++;

                for(int child : adjList.get(curr)) {
                    if(!visited.get(child)) {
                        que.offer(child);
                        visited.put(child, true);
                    }
                }
            }

            // 홀짝 트리가 되는 조건
            if(oddEvenCnt == 1) answer[0]++;
            // 역홀짝 트리가 되는 조건
            if(reverseOddEvenCnt == 1) answer[1]++;
        }

        return answer;
    }
}
