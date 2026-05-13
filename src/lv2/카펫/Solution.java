package lv2.카펫;

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        Set<int[]> xySet = new HashSet<>();
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
        	if(yellow % i == 0) {
        		if(i > yellow/i) {
        			xySet.add(new int[] {i, yellow/i});
        		}
        		else xySet.add(new int[] {yellow/i, i});
        	}
        }
        
        for(int[] xy : xySet) {
        	if(xy[0]*2 + xy[1]*2 + 4 == brown) {
        		answer = xy;
        		answer[0] += 2;
        		answer[1] += 2;
        		break;
        	}
        }
        
        return answer;
    }
}