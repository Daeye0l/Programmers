package lv2.이진_변환_반복하기;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int i = 0;
        int zeroCnt = 0;
        while(!s.equals("1")) {
        	i++;
        	int oneCnt = 0;
        	
        	for(int j = 0; j < s.length(); j++) {
            	if(s.charAt(j) == '1') oneCnt++;
            	else zeroCnt++;
            }
        
            s = changeNum(oneCnt);
        }
        
        answer[0] = i;
        answer[1] = zeroCnt;
        
        return answer;
    }
    
    private static String changeNum(int n) {
    	Stack<Integer> stack = new Stack<>();
    	while(n > 0) {
    		if(n == 1) {
    			stack.push(n);
    			break;
    		}
    		stack.push(n%2);
    		n /= 2;
    	}
    	
    	String changed = "";
    	while(!stack.isEmpty()) {
    		changed += String.valueOf(stack.pop());
    	}
    	
    	return changed;
    }
}