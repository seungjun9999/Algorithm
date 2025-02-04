import java.util.*;

class Solution {
    static int n, apc=0, maax = 0;
    static int[] info, answer = new int[11], list = new int[11];
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        for(int i=0;i<11;i++){
            apc += info[i] > 0 ? (10-i) : 0;
        }
        shot(0, 0, 0);
        
        if(maax == 0){
            return new int[] {-1}; 
        }
        return answer;
    }
    
    private void shot(int cnt, int sum, int a){

        if(cnt > n) {
            return;
        }
        
        if((sum - apc == maax && isBetter(cnt)) || sum - apc > maax){
            maax = sum - apc;
            list[10] += n-cnt;
            answer = list.clone();
            list[10] -= n-cnt;
        }
      
        
        for(int i = a; i < info.length; i++) {
            list[i] = info[i] + 1;
            if(info[i]>0) {
                apc -= (10-i);
            }          
            shot(cnt + info[i] + 1, sum+(10-i), i+1);
            if(info[i]>0) {
                apc += (10-i);
            }
            list[i] = 0;
        }     
    }
    
    private boolean isBetter(int cnt) {
        list[10] += n-cnt;
        for(int i=10;i >= 0; i--) {
            if(answer[i] != list[i]) {
                list[10] -= n-cnt;
                return list[i] > answer[i];
            }
        }
        return false;
    }
}