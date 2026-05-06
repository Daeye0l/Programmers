package lv2.숫자의_표현;

class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int start = 1;
        int end = 1;
        int sum = 1;
        
        // 투포인터로 확인
        while(end < n) {
        	// 현재 범위에 있는 숫자들의 합이 n인 경우
        	if(sum == n) {
        		// 카운트 증가 후 end 범위 한칸 증가
        		answer++;
        		end++;
        		sum += end;
        	}
        	// 현재 범위에 있는 숫자들의 합이 n보다 작은 경우
        	else if(sum < n) {
        		// end 범위 한칸 증가(합이 더 커져야 하기 때문)
        		end++;
        		sum += end;
        	}
        	// 현재 범위에 있는 숫자들의 합이 n보다 큰 경우
        	else {
        		// start 범위 한칸 증가(합이 더 작아져야 하기 때문)
        		sum -= start;
        		start++;
        	}
        }
        
        return answer;
    }
}