package lv2.다음_큰_숫자;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int c = n;
        int zeroCnt = 0;
        int oneCnt = 0;
        
        // 가장 오른쪽 비트에서부터 0의 개수 세기
        while((c & 1) == 0 && (c != 0)) {
        	zeroCnt++;
        	c >>= 1;
        }
        // 가장 오른쪽 비트에서부터 1의 개수 세기
        while((c & 1) == 1) {
        	oneCnt++;
        	c >>= 1;
        }
        
        // p는 오른쪽에서부터 처음으로 등장하는 "01" 패턴 중 0의 위치
        int p = zeroCnt + oneCnt;
        // 이 위치를 1로 우선 바꾸고
        answer = n;
        answer |= 1 << p;
        // 그 다음 위치부터는 모두 0으로 마스킹
        answer &= ~((1 << p) - 1);
        // 그 다음 오른쪽에서부터 oneCnt-1개 채움
        answer |= (1 << (oneCnt-1)) - 1;
        
        return answer;
    }
}