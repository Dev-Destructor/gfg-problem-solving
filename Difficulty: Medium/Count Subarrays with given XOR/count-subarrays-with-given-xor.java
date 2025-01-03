//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int n = arr.length;
        long ans = 0, prefix = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        
        for(int i = 0; i < n; i++) {
            prefix ^= arr[i];
            
            ans += map.getOrDefault(prefix ^ k, 0);
            
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        
        return ans;
    }
}