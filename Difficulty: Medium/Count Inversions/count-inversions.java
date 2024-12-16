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
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int merge(int arr[], int l, int m, int h) {
        int cnt = 0, lt = l, rt = m + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(lt <= m && rt <= h) {
            if (arr[lt] <= arr[rt]) {
                temp.add(arr[lt]);
                lt++;
            } else {
                temp.add(arr[rt]);
                rt++;
                cnt += (m - lt) + 1;
            }
        }
        
        while(lt <= m) {
            temp.add(arr[lt]);
            lt++;
        }
        
        while(rt <= h) {
            temp.add(arr[rt]);
            rt++;
        }
        
        for (int i = l; i <= h; i++) {
            arr[i] = temp.get(i - l);
        }
        
        return cnt;
    }
    
    static int mergeSort(int arr[], int l, int h) {
        int cnt = 0;
        
        if (l >= h) {
            return cnt;
        }
        
        int m = (l + h) / 2;
        
        cnt += mergeSort(arr, l, m);
        cnt += mergeSort(arr, m + 1, h);
        cnt += merge(arr, l, m, h);
        
        return cnt;
    }
    
    static int inversionCount(int arr[]) {
        // Your Code Here
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }
}