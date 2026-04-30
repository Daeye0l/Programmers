package lv2.최댓값과_최솟값;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s);
        int f = Integer.parseInt(st.nextToken());
        int max = f;
        int min = f;

        while(st.hasMoreTokens()) {
        	int n = Integer.parseInt(st.nextToken());
        	if(max < n) max = n;
        	if(min > n) min = n;
        }
        
        answer = min + " " + max;
        return answer;
    }
}