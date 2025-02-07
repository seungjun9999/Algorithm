import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n>0) {
            pq.offer((int)(n%10));
            n/=10;
        }
        while(!pq.isEmpty()) {
            answer += pq.poll();
            answer*=10;
        }
        return answer/10;
    }
}