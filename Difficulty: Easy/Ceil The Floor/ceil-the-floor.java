//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int n = arr.length;
        int c = Integer.MAX_VALUE, f = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] > x && arr[i] < c) {
                c = arr[i];    
            } else if(arr[i] < x && arr[i] > f) {
                f = arr[i];
            } else if(arr[i] == x) {
                return new int[] {arr[i], arr[i]};
            }
            else {
                continue;
            }
        }
        
        if(c == Integer.MAX_VALUE) {
            c = -1;
        }
        
        if(f == Integer.MIN_VALUE) {
            f = -1;
        }
        
        return new int[] {f, c};
    }
}

// i > x  