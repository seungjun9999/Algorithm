import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] nums = new String[numbers.length];
        int i=0;
        for(int num : numbers) {
            nums[i++] = Integer.toString(num);
        }
        Arrays.sort(nums,(s1,s2) -> {
            int a = Integer.parseInt(s1+s2);
            int b = Integer.parseInt(s2+s1);
            return b-a;
        });
        for(String num : nums) {
            sb.append(num);
        }
        return sb.toString().charAt(0) == '0'?"0" : sb.toString();
    }
}