//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int maxL = arr[l];
        int maxR = arr[r];
        int totalWater = 0;
        
        while(l <= r) {
            if(arr[l] <= arr[r]) {
                if (arr[l] >= maxL) {
                    maxL = arr[l];
                } else {
                    totalWater += maxL - arr[l];
                }
                l++;
            } else {
                if (arr[r] >= maxR) {
                    maxR = arr[r];
                } else {
                    totalWater += maxR - arr[r];
                }
                r--;
            }
        }
        
        return totalWater;
    }
}