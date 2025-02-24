import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;
        for(int i=0;i<m;i++) {
            answer = Math.max(answer,board[0][i]);
        }
        for(int i=0;i<n;i++) {
            answer = Math.max(answer,board[i][0]);
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(board[i][j]==0) continue;
                board[i][j] = Math.min(Math.min(board[i][j-1],board[i-1][j]),board[i-1][j-1])+1;
                answer = Math.max(board[i][j],answer);
            }
        }
        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<m;j++) {
        //         System.out.print(board[i][j]);
        //     }
        //     System.out.println();
        // }
        
        return (int)Math.pow(answer,2);
    }
}