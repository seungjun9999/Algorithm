import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(tangerine);
        int cnt=1;
        int answer = 0;
        for(int i=1;i<tangerine.length;i++) {
            if(tangerine[i-1] !=tangerine[i]) {
                list.add(cnt);
                cnt=1;
            }else{
                cnt++;
            }
        }
        list.add(cnt);
        Collections.sort(list,Collections.reverseOrder());
        for(int a : list) {
            answer++;
            if(k-a<=0){
                break;
            }else {
                k-=a;
            }          
        }
        return answer;
    }
}