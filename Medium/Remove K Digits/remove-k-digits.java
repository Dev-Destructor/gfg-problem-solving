//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        if (S.length() == K) return "0";

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            while (!deque.isEmpty() && K > 0 && deque.peekLast() > current) {
                deque.removeLast();
                K--;
            }
            deque.addLast(current);
        }

        for (int i = 0; i < K; i++) {
            deque.removeLast();
        }

        StringBuilder smallest = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.removeFirst();
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            smallest.append(digit);
        }

        return smallest.length() == 0 ? "0" : smallest.toString();
    }
}