//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int n = arr.length, pSum = 0, length = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                pSum += -1;
            } else {
                pSum += 1;
            }
            
            if(pSum == 0) {
                length = i + 1;
            }
            
            if(map.containsKey(pSum)) {
                length = Math.max(length, i - map.get(pSum));
            } else {
                map.put(pSum, i);
            }
        }
        
        return length;
    }
}