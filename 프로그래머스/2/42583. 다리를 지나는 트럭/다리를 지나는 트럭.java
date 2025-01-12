import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> dq =  new ArrayDeque<>();
        for(int i=0;i<bridge_length;i++){
            dq.offer(0);
        }
        int answer = 0;
        int n=0;
        while(!dq.isEmpty()) {
            int now = dq.poll();
            weight+=now;
            if (n<truck_weights.length) {
                if(weight - truck_weights[n] >= 0) {
                    dq.offer(truck_weights[n]);
                    weight -=truck_weights[n];
                    n++;
                } else{ 
                    dq.offer(0);
                }
            }
            answer++;
        }
        return answer;
    }
}