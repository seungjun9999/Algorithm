import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        int answer = 1;
        for(String[] clothe : clothes) {
            map.put(clothe[1],map.getOrDefault(clothe[1],0) +1);
        }
        for(int i : map.values()){
            answer *= i+1;
        }
        
        return answer-1;
    }
}