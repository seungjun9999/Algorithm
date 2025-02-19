import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer=0;
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> recent = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int a : topping) {
            hs.add(a);
            hm.put(a,hm.getOrDefault(a,0)+1);
        }
        int len = hs.size();
        
        for(int a : topping) {
            recent.add(a);
            hm.put(a,hm.get(a)-1);
            if(hm.get(a)==0) {
                len--;
            }
            if(recent.size() == len) {
                answer++;
            }
        }
        return answer;
    }
}