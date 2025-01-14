import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> rep = new HashMap<>();
        HashMap<String,Integer> result = new HashMap<>();
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        HashSet<String> repoList = new HashSet<>();
        for(int i=0;i<report.length;i++) {
            String[] arr = report[i].split(" ");
            if(!repoList.contains(arr[0]+" "+arr[1])){
                repoList.add(arr[0]+" "+arr[1]);
                rep.put(arr[1],rep.getOrDefault(arr[1],0)+1);
                if(!hm.containsKey(arr[1])) {
                    hm.put(arr[1],new ArrayList<>());
                }
                hm.get(arr[1]).add(arr[0]);
            }   
        }
        for(String key : rep.keySet()) {
            if(rep.get(key) >= k && hm.containsKey(key)) {
                ArrayList<String> list = hm.get(key);
                for(String arr :list) {
                    result.put(arr,result.getOrDefault(arr,0)+1);
                }
            }
        }
        int cnt=0;
        for(String name:id_list){
            if(!result.containsKey(name)){
                answer[cnt]=0;
            }else{
                answer[cnt] = result.get(name);
            }
            cnt++;
        }
        return answer;
    }
}