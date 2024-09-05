//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited = new boolean[V];
        int provinces = 0;
        
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                provinces++;
                dfs(V, adj, visited, i);
            }
        }
        
        return provinces;
    }
    
    public static void dfs(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start) {
        visited[start] = true;
        
        for(int i = 0; i < V; i++) {
            if(adj.get(start).get(i) == 1 && !visited[i]) {
                visited[i] = true;
                dfs(V, adj, visited, i);
            }
        }
    }
};