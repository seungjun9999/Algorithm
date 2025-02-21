import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int result = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int player : players) {
            int a = player / m;
            if (a != 0) {
                int sum = player / m - (dq.size());
                sum = sum > 0 ? sum : 0;
                result += sum;
                for (int i = 0; i < sum; i++) {
                    dq.offer(k);
                }
            }
            int n = dq.size();
            for (int i = 0; i < n; i++) {
                int now = dq.poll();
                now--;
                if (now != 0) dq.offer(now);
            }
        }
        return result;
    }
}