import java.util.*;

class Solution {
    static int n, apc=0, maax = 0, lastIdx=0, lastCnt=0;
    static int[] info;
    static ArrayList<Integer> answer = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        for(int i=0;i<11;i++){
            apc += info[i] > 0 ? (10-i) : 0;
            list.add(0);
            answer.add(0);
        }
        
        shot(0, 0, 0);
        
        if(maax == 0){
            return new int[] {-1}; 
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void shot(int cnt, int sum, int a){

        if(cnt > n) {
            return;
        }
        
        if(sum - apc >= maax) {
            if((sum - apc == maax && isBetter(cnt)) || sum - apc > maax){
                maax = sum - apc;
                list.set(10,list.get(10) + n-cnt);
                answer = new ArrayList<>(list);
                list.set(10,list.get(10) - (n-cnt));
            }
        }   
        
        for(int i = a; i < info.length; i++) {
            list.set(i, info[i] + 1);
            if(info[i]>0) {
                apc -= (10-i);
            }          
            shot(cnt + info[i] + 1, sum+(10-i), i+1);
            if(info[i]>0) {
                apc += (10-i);
            }
            list.set(i,0);
        }     
    }
    
    private boolean isBetter(int cnt) {
        list.set(10,list.get(10) + n-cnt);
        for(int i=10;i >= 0; i--) {
            if(answer.get(i) - list.get(i) == 0) {
                continue;
            }else {
                if(answer.get(i) - list.get(i) > 0) {
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}