class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a1 = arr1.length;
        int a2 = arr1[0].length;
        
        int b1 = arr2.length;
        int b2 = arr2[0].length;
        int[][] answer = new int[a1][b2];
        
        for(int i=0; i < a1; i++){
            for(int k = 0 ;k <  b2; k++){
                for(int j=0; j < b1; j++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];               
                }
            }
        }
        
        return answer;
    }
}