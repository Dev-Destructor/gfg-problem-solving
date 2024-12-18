//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int minI = 0;
        int l = 0, h = arr.size() - 1;
        
        if(arr.get(l) < arr.get(h)) {
                return l;
        }
        
        while(l <= h) {
            int m = (l + h) / 2;
            
            if(arr.get(m) <= arr.get(minI)) {
                minI = m;
            }
            
            
            if(arr.get(l) <= arr.get(m)) {
                if(arr.get(l) < arr.get(minI)) {
                    minI = l;
                }
                l = m + 1;
            } else {
                if(arr.get(h) < arr.get(minI)) {
                    minI = h;
                }
                h = m - 1;
            }
        }
        
        return minI;
    }
}