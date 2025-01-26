class Solution {
    static int start = 1, end = 0, mid;
    static long answer = 0;
    public int solution(int[] diffs, int[] times, long limit) {
        for(int diff : diffs) {
            end = Math.max(end,diff);
        }
        int result = end;
        
        while (start < end) {
            answer = 0;
            mid = (start + end) / 2;
            for(int i=0;i< diffs.length; i++) {
                if(mid - diffs[i] >= 0) {
                    answer += (long) times[i];
                } else {
                    answer += (long) ((times[i] + times[i-1]) * (diffs[i] - mid)) + (long)times[i];
                }
            }
            if(limit < answer) {
                start = mid + 1;
            }else { 
                end = mid;
                result = Math.min(end, result);
            }
        }
        
        return end;
    }
}