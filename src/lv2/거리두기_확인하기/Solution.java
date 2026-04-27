package lv2.거리두기_확인하기;

import java.util.*;

class Solution {
	static int[][] coords = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
        	String[] place = places[i];
        	List<Participant> list = new ArrayList<>();
        	
        	for(int j = 0; j < 5; j++) {
        		for(int k = 0; k < 5; k++) {
        			if(place[j].charAt(k) == 'P') {
        				list.add(new Participant(j, k, 0));
        			}
        		}
        	}
        	
        	boolean isValid = true;
        	
        	for(Participant start : list) {
        		Queue<Participant> queue = new LinkedList<>();
            	boolean[][] visited = new boolean[5][5];
        		
            	queue .offer(start);
        		visited[start.x][start.y] = true;
        		
        		while(!queue.isEmpty()) {
            		Participant p = queue.poll();
            		
            		if(p.dist >= 2) continue;
            		
            		for(int[] coord : coords) {
            			int nx = p.x + coord[0];
            			int ny = p.y + coord[1];
            			if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
            				if(place[nx].charAt(ny) == 'P') {
            					isValid = false;
            					break;
            				}
            				else if(place[nx].charAt(ny) != 'X'){
            					queue.offer(new Participant(nx, ny, p.dist+1));
            					visited[nx][ny] = true;
            			
            				}
            			}
            		}
            		if(!isValid) break;
            	}
        		if(!isValid) break;
        	}
        	
        	if(isValid) answer[i] = 1;
        	else answer[i] = 0;
        }
        
        return answer;
    }
    
   
    
    private static class Participant {
    	private int x;
    	private int y;
    	private int dist;
    	
    	Participant(int x, int y, int dist) {
    		this.x = x;
    		this.y = y;
    		this.dist = dist;
    	}
    }
}