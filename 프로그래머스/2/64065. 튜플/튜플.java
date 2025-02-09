import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(0,s.length()-2).replace("{","");
        String[] arr = s.split("},");
        Arrays.sort(arr,(o1,o2) -> o1.length() - o2.length());
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<arr.length;i++) {
            String[] num = arr[i].split(",");
            for(String n : num) {
                if(!hs.contains(n)) {
                    hs.add(n);
                    list.add(Integer.parseInt(n));
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}