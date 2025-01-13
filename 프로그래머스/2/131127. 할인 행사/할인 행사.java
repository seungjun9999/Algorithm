import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        int cnt = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(want[i], number[i]);
            cnt += number[i];
        }
        for (int i = 0; i < discount.length - cnt + 1; i++) {
            HashMap<String, Integer> dis = new HashMap<>();
            for (int j = i; j < i + cnt; j++) {
                dis.put(discount[j], dis.getOrDefault(discount[j], 0) + 1);
            }
            if (hm.equals(dis)) {
                answer++;
            }
        }
        return answer;
    }
}