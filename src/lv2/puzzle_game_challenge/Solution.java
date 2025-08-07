package lv2.puzzle_game_challenge;

public class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        answer = binarySearch(1, 100000, limit, diffs, times);
        return answer;
    }

    private static long getSolveTime(int level, int[] diffs, int[] times) {
        long time = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level) time += times[i];
            else time += (long)(times[i]+times[i-1]) * (diffs[i]-level) + times[i];
        }
        return time;
    }

    private static int binarySearch(int start, int end, long limit, int[] diffs, int[] times) {
        // 숙련도 이분탐색
        while(start < end) {
            int mid = (start+end) / 2;

            // 현재 숙련도로 모든 퍼즐을 제한 시간 안에 해결 할 수 없는 경우
            if(getSolveTime(mid, diffs, times) > limit) {
                // 숙련도를 키워야함
                start = mid+1;
            }
            // 현재 숙련도로 모든 퍼즐을 제한 시간 안에 해결할 수 있는 경우
            else end = mid;
        }

        // lower bound 반환(찾은 값이 모든 퍼즐을 제한 시간 내에 해결할 수 있는 최소 숙련도 값이기 때문)
        return start;
    }
}
