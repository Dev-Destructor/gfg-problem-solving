//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    private boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
    
    private boolean isValid(int num, boolean[] prime) {
        return num >= 1000 && prime[num];
    }
    
    private int bfs(int num1, int num2, boolean[] prime) {
        if (num1 == num2) {
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{num1, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0], depth = current[1];
            
            if (num == num2) {
                return depth;
            }
            
            if (visited.contains(num)) {
                continue;
            }
            visited.add(num);
            
            String numStr = String.valueOf(num);
            for (int i = 0; i < 4; i++) {
                for (char c = '0'; c <= '9'; c++) {
                    if (i == 0 && c == '0') continue; // Avoid leading zeros
                    String newNumStr = numStr.substring(0, i) + c + numStr.substring(i + 1);
                    int newNum = Integer.parseInt(newNumStr);
                    if (isValid(newNum, prime) && !visited.contains(newNum)) {
                        queue.offer(new int[]{newNum, depth + 1});
                    }
                }
            }
        }
        
        return -1; // Unreachable
    }
    
    int solve(int num1, int num2) {
        boolean[] prime = sieveOfEratosthenes(9999);
        return bfs(num1, num2, prime);
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends