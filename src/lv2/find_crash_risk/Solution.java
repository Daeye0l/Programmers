package lv2.find_crash_risk;

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Map<Integer, int[]> pointsMap = new HashMap<>();
        Queue<Robot> queue = new LinkedList<>();
        
        for(int i = 1; i <= points.length; i++) {
        	pointsMap.put(i, points[i-1]);
        }
        
        for(int[] route : routes) {
        	int[] start = pointsMap.get(route[0]);
        	Queue<Integer> dests = new LinkedList<>();
        	
        	for(int i = 1; i < route.length; i++) {
        		dests.offer(route[i]);
        	}
        	
        	Robot robot = new Robot(start[0], start[1], dests);
        	queue.offer(robot);
        }
        
        // 모든 로봇이 목표 지점에 도착할 때까지 반복
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	Map<String,Integer> posCount = new HashMap<>();
        	
        	// 모든 로봇은 동시에 한 사이클을 거쳐야 함
        	for(int i = 0; i < size; i++) {
        		Robot robot = queue.poll();
        		String pos = robot.r + "," + robot.c;
        		// 모든 로봇이 있는 위치의 카운트를 누적
        		posCount.put(pos, posCount.getOrDefault(pos, 0)+1);
        		queue.offer(robot);
        	}
        	
        	// 충돌 횟수 누적
        	for(int count : posCount.values()) {
        		if(count >= 2) answer++;
        	}
        	
        	// 로봇 이동
        	for(int i = 0; i < size; i++) {
        		Robot robot = queue.poll();
        		
        		if(robot.dests.isEmpty()) continue;
        		
        		int[] dest = pointsMap.get(robot.dests.peek());
        		if(robot.r != dest[0]) {
                    if(robot.r > dest[0]) robot.r--;
                    else robot.r++;
                } else if(robot.c != dest[1]) {
                    if(robot.c > dest[1]) robot.c--;
                    else robot.c++;
                }
        		
        		if(robot.r == dest[0] && robot.c == dest[1]) {
        			robot.dests.poll();
        		}
        		
        		queue.offer(robot);
        	}
        }
        
        return answer;
    }
    
    private static class Robot {
    	private int r;
    	private int c;
    	private Queue<Integer> dests;
    	
    	Robot(int r, int c, Queue<Integer> dests) {
    		this.r = r;
    		this.c = c;
    		this.dests = dests;
    	}
    }
}