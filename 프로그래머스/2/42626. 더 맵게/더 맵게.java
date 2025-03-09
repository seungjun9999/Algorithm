import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt=0;
        for(int s : scoville) {
            pq.offer(s);
        }
        while(pq.size()>1) {
            int a = pq.poll();
            if(a>=K){
                break;
            }
            int b = pq.poll();
            pq.offer(a+(b*2));
            cnt++;
        }
        return pq.poll() < K ? -1 : cnt;
    }
}