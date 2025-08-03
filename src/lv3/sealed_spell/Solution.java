package lv3.sealed_spell;

import java.util.Arrays;

public class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        long[] banNums = new long[bans.length];

        // 삭제 시키는 주문을 26진수로 바꿔 저장(몇 번째 주문인지)
        for(int i = 0; i < bans.length; i++) {
            banNums[i] = spellToNum(bans[i]);
        }

        // 찾으려는 위치보다 이전에 삭제해야 하는 주문이 있다면 건너뜀
        Arrays.sort(banNums);
        for(long banNum : banNums) {
            if(banNum <= n) n++;
        }

        answer = numToSpell(n);
        return answer;
    }

    // 주문을 26진수로 변경
    private static long spellToNum(String spell) {
        long num = 0;
        int j = 0;
        for(int i = spell.length()-1; i >= 0; i--) {
            num += (long)((spell.charAt(i)-96) * Math.pow(26, j++));
        }
        return num;
    }

    // 26진수를 주문으로 변경
    private static String numToSpell(long num) {
        StringBuilder spell = new StringBuilder();
        while(num > 0) {
            long mod = (num-1)%26+1;
            spell.append((char)(mod+96));
            num = (num-1)/26;
        }
        spell.reverse();
        return spell.toString();
    }
}
