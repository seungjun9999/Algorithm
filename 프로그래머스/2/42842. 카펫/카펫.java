import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = {};
        int end = brown/2 -1;
        int start = (int)Math.ceil((double)(brown + 4) / 4);
        System.out.print(end+" "+start);
        while(start<=end) {
            int mid = (end + start) / 2 ;
            int height = (brown - (mid*2) + 4) / 2 ;
            int hap = mid*height;
            if(hap == sum) {
                return new int[] {mid,height};
            }else if (hap > sum) {
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return answer;
    }
}