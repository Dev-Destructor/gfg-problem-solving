//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
        int MOD = 1000000007;
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        
        for (int j = 2; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                for (int k = i / 2; k >= 1; k--) {
                    dp[i][j] = (dp[i][j] + dp[k][j - 1]) % MOD;
                }
            }
        }
        
        int total = 0;
        for (int i = 1; i <= m; i++) {
            total = (total + dp[i][n]) % MOD;
        }
        
        return total;
    }
}