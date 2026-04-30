package lv2.JadenCase_문자열_만들기;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String lower = s.toLowerCase();
        String result = "";
        boolean isFirst = true;
        
        for(int i = 0; i < lower.length(); i++) {
        	char c = lower.charAt(i);
        	
        	if(c == ' ') {
        		result += c;
        		isFirst = true;
        	}
        	else if(isFirst) {
        		result += Character.toUpperCase(c);
        		isFirst = false;
        	}
        	else {
        		result += c;
        	}
        }
        answer = result;
        
        return answer;
    }
}