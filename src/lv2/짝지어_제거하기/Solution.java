package lv2.짝지어_제거하기;

import java.util.*;

class Solution {
	// 효율성 실패
//    public int solution(String s) {
//    
//        int answer = 0;
//        
//        while(true) {
//        	String nextString = ""; // 짝을 제거하고 난 후의 문자열
//        	boolean pairExist = false; // 지워진 짝이 있는지 여부
//        	
//        	// 짝이 있다면 제거하고 제거한 문자열 저장
//        	for(int i = 0; i < s.length(); i++) {
//        		if(pairExist) break;
//        		
//        		// 짝이 있는 경우
//        		if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
//        			if(i-1 >= 0) {
//        				nextString += s.subSequence(0, i);
//        			}
//        			if(i+2 < s.length()) {
//        				nextString += s.subSequence(i+2, s.length());
//        			}
//        			pairExist = true;
//        		}
//        	}
//        	
//        	// 문자열에 짝이 없다면 종료(불가능한 경우)
//        	if(!pairExist) {
//        		answer = 0;
//        		break;
//        	}
//        	
//        	s = nextString;
//        	
//        	// 문자열에서 짝을 찾아 모두 제거된 경우(가능한 경우)
//        	if(s.equals("")) {
//        		answer = 1;
//        		return answer;
//        	}
//        }
//        
//        return answer;
//    }
	
	public int solution(String s) {
    
        int answer = -1;

        Stack<Character> stack = new Stack<Character>(); 
        for(int i = 0; i < s.length(); i++) {
        	if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
        		stack.pop();
        	}
        	else stack.push(s.charAt(i));
        }
        
        if(stack.isEmpty()) {
        	answer = 1;
        }
        else answer = 0;
        
        return answer;
    }
}