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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static int evenlyDivides(int N){
        int count = 0;
        int actualN = N;
        
        while(N > 0) {
            int num = N % 10;
            
            if (num != 0 && actualN % num == 0) {
                count++;
            }
            
            N = N / 10;
        }
        
        return count;
    }
}

/*
N = 22074
num = 4
count = 1
N = 2207
num = 7

*/