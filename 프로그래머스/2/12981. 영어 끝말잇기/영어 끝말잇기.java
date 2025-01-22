import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        int cnt=0;
        int idx=0;
        
        list.get(cnt).add(words[idx]);
        hs.add(words[idx]);
        cnt++;
        idx++;
        
        while(idx < words.length) {
            list.get(cnt).add(words[idx]);
            if(words[idx-1].charAt(words[idx-1].length()-1) != words[idx].charAt(0) || hs.contains(words[idx])){
                return new int[] {cnt+1,list.get(cnt).size()};
            }
            hs.add(words[idx]);
            cnt = (cnt+1)%n;
            idx++;
        }
        return new int[] {0,0};
    }
}