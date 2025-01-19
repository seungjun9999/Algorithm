import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list =  new ArrayList<>();
    static int maax = 0;
    public int solution(int[] info, int[][] edges) {
        
        Set<Integer> pos = new HashSet<>();
        int sheep = 0;
        int wolf = 0;
        
        for(int i=0;i<info.length;i++) {
            list.add(new ArrayList<>());
        }
        
        for(int[] num : edges) {
            list.get(num[0]).add(num[1]);
        }
        
        pos.add(0);
        dfs(0,pos,sheep,wolf,info);
        return maax;
    }
    void dfs(int recent, Set<Integer> pos, int sheep, int wolf,int[] info) {
          
            if(info[recent] == 0){
                sheep+=1;
            }else{
                wolf+=1;
            }
            maax = Math.max(maax,sheep);
            if(sheep<=wolf) return;

            Set<Integer> newgo = new HashSet<>(pos);
            newgo.addAll(list.get(recent));
            newgo.remove(recent);
        
            for(int a: newgo) {
                dfs(a,newgo,sheep,wolf,info);
            }  
    }
}