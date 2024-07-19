//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    // static long sumOfDivisor(int V) {
    //     long sum = 1 + V;
    //     for (int i = 2; i <= Math.sqrt(V); i++) {
    //         if (V % i == 0) {
    //             sum += i;
    //             if (V / i != i) {
    //                 sum += V / i;
    //             }
    //         }
    //     }
    //     return sum;
    // }
    
    static long sumOfDivisors(int N){
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (i * (N / i));
        }
        
        return sum;
    }
}

/*
N = 4
SumOFDivisiors(1) 


*/