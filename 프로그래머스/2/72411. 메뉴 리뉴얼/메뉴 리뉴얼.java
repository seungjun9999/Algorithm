import java.util.*;

class Solution {
    static HashMap<String,Integer> combi;
    static ArrayList<String> answer = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        a: for(int len : course) {
            combi = new HashMap<>();
            for(String order : orders) {
                if(order.length() >= len) {
                    combination(order,len,"",0);
                }  
            }
            if(combi.isEmpty()) continue a;
            int maax = Collections.max(combi.values());
            if(maax > 1) {
                for(String key : combi.keySet()) {
                    if(combi.get(key) == maax) {
                        answer.add(key);
                    }
                }
            }
        }
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    void combination(String order, int len, String current,int idx) {
        
        if(current.length() == len) {
            char[] arrchar = current.toCharArray();
            Arrays.sort(arrchar);
            String key = new String(arrchar);
            combi.put(key,combi.getOrDefault(key,0)+1);
            return;
        }
        
        for(int i=idx;i<order.length();i++) {
            combination(order,len,current+order.charAt(i),i+1);
        }
    }
}