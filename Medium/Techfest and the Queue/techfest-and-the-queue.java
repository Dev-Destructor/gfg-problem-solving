//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        long MOD = 1000000007;
        long sum = 0;

        boolean[] isPrime = new boolean[(int) (b + 1)];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= b; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= b; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (long i = a; i <= b; i++) {
            long num = i;
            for (int j = 2; j * j <= num; j++) {
                if (isPrime[j] && num % j == 0) {
                    int count = 0;
                    while (num % j == 0) {
                        num /= j;
                        count++;
                    }
                    sum = (sum + count) % MOD;
                }
            }
            if (num > 1) {
                sum = (sum + 1) % MOD;
            }
        }

        return sum;
    }
}
        
