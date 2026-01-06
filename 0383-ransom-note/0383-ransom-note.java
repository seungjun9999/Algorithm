import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<magazine.length();i++) {
            char c  = magazine.charAt(i);
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++) {
            char d = ransomNote.charAt(i);
            if(hm.getOrDefault(d,0) == 0) {
                return false;
            }
            hm.put(d,hm.get(d)-1);
        }
        return true;
    }
}