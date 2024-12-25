//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean canWePlace(int[] stalls, int n, int dist, int cows) {
        int cnt = 1;
        int last = stalls[0];
        
        for(int i = 1; i < n; i++) {
            if(stalls[i] - last >= dist) {
                cnt++;
                last = stalls[i];
            }
        }
        
        if(cnt >= cows) return true;
        
        return false;
    }
    
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        
        int l = 1, h = stalls[n - 1] - stalls[0];
        
        while(l <= h) {
            int m = (l + h) / 2;
            
            if(canWePlace(stalls, n, m, k) == true) {
                l  = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        return h;
    }
}