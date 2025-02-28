class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = stations.length;

        for (int i = 1; i < len; i++) {
            int gap = (stations[i] - w) - (stations[i - 1] + w) - 1;
            if (gap > 0) {
                answer += (gap / ((w * 2) + 1)) + ((gap % ((w * 2) + 1)) > 0 ? 1 : 0);
            }
        }
        if (stations[0] - w > 1) {
            int leftGap = stations[0] - w - 1;
            answer += (leftGap / ((w * 2) + 1)) + ((leftGap % ((w * 2) + 1)) > 0 ? 1 : 0);
        }
        if (stations[len - 1] + w < n) {
            int rightGap = n - (stations[len - 1] + w);
            answer += (rightGap / ((w * 2) + 1)) + ((rightGap % ((w * 2) + 1)) > 0 ? 1 : 0);
        }

        return answer;
    }
}