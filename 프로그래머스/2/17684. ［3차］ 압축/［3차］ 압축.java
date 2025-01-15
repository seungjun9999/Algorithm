import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int idx = 26;
        for (int i = 0; i < idx; i++) {
            hm.put(String.valueOf((char) ('A' + i)), 1 + i);
        }
        int a = 0;
        String arr = "";
        while (msg.length() > a) {
            arr += msg.charAt(a);
            if ((a + 1) < msg.length() && !hm.containsKey(arr + msg.charAt(a + 1))) {
                hm.put(arr + msg.charAt(a + 1), ++idx);
                answer.add(hm.get(arr));
                arr = "";
            }
            a++;
        }
        answer.add(hm.get(arr));
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}