//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    Stack<Integer>stack;
    HashMap<Integer,Integer>map;
    PriorityQueue<Integer>pq;
    public Solution() {
        stack=new Stack<>();
        map=new HashMap<>();
        pq=new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        map.put(x,map.getOrDefault(x,0)+1);
        pq.add(x);
    }

    public void pop() {
        // code here
        if(!stack.isEmpty()){
            int top=stack.pop();
            map.put(top,map.get(top)-1);
            if(map.get(top)==0){
                map.remove(top);
                pq.remove(top);
            }
            
        }
    }

    public int peek() {
        // code here
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        // code here
        if(pq.isEmpty()) return -1;
        return pq.peek();
    }
}

