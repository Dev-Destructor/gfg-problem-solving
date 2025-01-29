//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        int n = e;    
        double ans = 1.0;
       
        if(n < 0) n = n * -1;
       
        while(n > 0) {
            if(n % 2 == 1){
                ans *= b;
                n--;
            } else {
                b = b * b;
                n = n/2;
            }  
        }
       
       return (e < 0) ? 1/ans : ans;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends