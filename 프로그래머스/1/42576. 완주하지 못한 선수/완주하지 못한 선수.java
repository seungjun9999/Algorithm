import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String name : completion) {
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        }
        for (String arr : participant) {
            if (hm.getOrDefault(arr, 0) == 0) {
                return arr;
            }
            hm.put(arr, hm.get(arr) - 1);
        }
        return null;
    }
}