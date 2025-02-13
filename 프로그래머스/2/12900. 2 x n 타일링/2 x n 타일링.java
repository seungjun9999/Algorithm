class Solution {
    public int solution(int n) {
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        // 피보나치..?
        for (int i = 3; i <= n; i++) {
            num[i] = (num[i - 1] + num[i - 2]) % 1000000007;
        }
        return num[n];
    }
}