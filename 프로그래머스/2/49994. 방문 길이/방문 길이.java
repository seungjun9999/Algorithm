import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][]num = new int[11][11];
        HashSet<String> hs = new HashSet<>();
        int[] my = {5,5};
        for(int i=0;i<dirs.length();i++){
            char go = dirs.charAt(i);
            if(go=='U'){
                int recent = my[0]+1;
                if(check(recent)){
                    hs.add(""+my[0]+my[1]+recent+my[1]);
                    hs.add(""+recent+my[1]+my[0]+my[1]);
                    my = new int[]{recent,my[1]};
                }
            }else if(go=='D'){
                int recent = my[0]-1;
                if(check(recent) ){
                    hs.add(""+my[0]+my[1]+recent+my[1]);
                    hs.add(""+recent+my[1]+my[0]+my[1]);
                    my = new int[]{recent,my[1]};
                }
            }else if(go=='R'){
                int recent = my[1]+1;
                if(check(recent)){
                    hs.add(""+my[0]+my[1]+my[0]+recent);
                    hs.add(""+my[0]+recent+my[0]+my[1]);
                    my = new int[]{my[0],recent};
                }
            }else{
                int recent = my[1]-1;
                if(check(recent)){
                    hs.add(""+my[0]+my[1]+my[0]+recent);
                    hs.add(""+my[0]+recent+my[0]+my[1]); 
                    my = new int[]{my[0],recent};
                }
            }
        }
        return hs.size()/2;
    }
    static boolean check(int a){
        if(0<=a && a<11){
            return true;
        }
        return false;
    }
}