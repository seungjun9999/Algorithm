import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<name.length;i++) {
            hm.put(name[i],yearning[i]);
        }
        int[] result = new int[photo.length];
        for(int j=0;j<photo.length;j++) {
            for(int i=0;i<photo[j].length;i++) {
                result[j] += hm.getOrDefault(photo[j][i],0);
            }
        }
        return result;
    }
}