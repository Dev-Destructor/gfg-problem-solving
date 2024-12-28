//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }
    int median(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(mat, m, n, mid);
            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}