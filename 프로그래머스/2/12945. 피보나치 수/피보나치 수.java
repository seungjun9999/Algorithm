class Solution {
    static int[] num;
    static int m = 1234567;

    public int solution(int n) {
        num = new int[n + 1];
        num[1] = 1;
        return fibo(n);
    }

    private int fibo(int n) {
        if (num[n] != 0)
            return num[n];
        fibo(n - 1);
        num[n] = num[n - 1] % m + num[n - 2] % m;
        return num[n] % m;
    }
}