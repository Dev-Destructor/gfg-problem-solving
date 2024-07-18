//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends



class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        Long[] result = new Long[2]; 
        Long gcd;
        Long lcm;
        
        Long originalA = A;
        Long originalB = B;
        
        while (A > 0 && B > 0) {
            if (A > B) {
                A = A % B;
            } else {
                B = B % A;
            }
        }
        gcd = (A == 0) ? B : A;
        
        lcm = (originalA * originalB) / gcd;
        
        result[0] = lcm;
        result[1] = gcd;
    
        return result;
    }
};