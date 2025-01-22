import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int get = nums.length/2;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) {
            hs.add(num);
        }
        if(hs.size() <= get) {
            return hs.size();
        }
        return get;
    }
}