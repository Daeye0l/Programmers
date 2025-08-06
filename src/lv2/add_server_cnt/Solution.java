package lv2.add_server_cnt;

import java.util.*;

public class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        Deque<Integer> server = new ArrayDeque<>();
        for(int i = 0; i < players.length; i++) {
            // 시간대가 증가하면 운영중인 서버들의 시간을 1감소하고 운영이 끝난 서버는 제거
            if(!server.isEmpty()) {
                int size = server.size();
                for(int j = 0; j < size; j++) {
                    int time = server.pollFirst();
                    if(time-1 != 0) server.offerLast(time-1);
                }
            }

            // 서버가 추가로 필요한 경우
            if(players[i] >= (server.size()+1) * m) {
                int need = players[i]/m - server.size();
                answer += need;
                for(int j = 0; j < need; j++) server.offerLast(k);
            }
        }

        return answer;
    }
}
