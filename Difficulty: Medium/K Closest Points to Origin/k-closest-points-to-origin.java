//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Tuple {
    public int dist, x, y;
    public Tuple(int a, int b, int c) {
        dist = a;
        x = b;
        y = c;
    }
    
    public int getDist() {
        return this.dist;
    }
}

class TupleComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple s1, Tuple s2) {
        if (s1.getDist() > s2.getDist()) return -1;
        else if (s2.getDist() > s1.getDist()) return 1;
        return 0;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new TupleComparator());
        
        for (int i = 0; i < points.length; ++i) {
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            
            if (pq.size() < k) {
                pq.add(new Tuple(dist, points[i][0], points[i][1]));
            }
            else if (pq.peek().getDist() > dist) {
                pq.poll();
                pq.add(new Tuple(dist, points[i][0], points[i][1]));
            }
        }
        
        int[][] ans = new int[k][2];
        int idx = 0;
        
        while (!pq.isEmpty()) {
            Tuple tt = pq.poll();
            ans[idx][0] = tt.x;
            ans[idx++][1] = tt.y;
        }
        
        return ans;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends