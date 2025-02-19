class Solution {
    public int[] solution(String s) {
        int dep=0,cnt=0;
        while(!s.equals("1")) {
            int slen = s.length();
            int len = s.replace("0","").length();
            cnt+= (slen - len);
            s = Integer.toBinaryString(len);
            dep++;
        }
        return new int[] {dep, cnt};
    }
}