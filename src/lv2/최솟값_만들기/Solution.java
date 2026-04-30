package lv2.최솟값_만들기;

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0, j = A.length-1; i < j; i++, j--) {
        	int temp = A[i];
        	A[i] = A[j];
        	A[j] = temp;
        }
        
        for(int i = 0; i < A.length; i++) {
        	answer += A[i]*B[i];
        }

        return answer;
    }
}