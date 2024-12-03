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
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        
        int l = 0, h = n - 1;
        
        while(l <= h) {
            int m = (l + h) / 2;
            
            if(arr[m] == target) {
                int fo = m, lo = m, am = m;
                
                while(m != 0 && arr[m] == arr[m - 1]) {
                    m--;
                }
                
                fo = m;
                
                while(am != n - 1 && arr[am] == arr[am + 1]) {
                    am++;
                }
                
                lo = am;
                
                return (lo - fo) + 1;
                
            } else if(arr[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        return 0;
    }
}
