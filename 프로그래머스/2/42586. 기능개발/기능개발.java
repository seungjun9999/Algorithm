import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
         ArrayDeque<Integer> num = new ArrayDeque<>();
        int cnt = 0;
        int day = 0;
        for (int i = 0; i < progresses.length; i++) {
            int recent = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if (i == 0) {
                day = recent;
                cnt++;
            } else if (day >= recent) {
                cnt++;
            } else {
                num.offer(cnt);
                day = recent;
                cnt = 1;
            }
        }
        num.offer(cnt);
        
        return num.stream().mapToInt(i -> i).toArray();
    }
}