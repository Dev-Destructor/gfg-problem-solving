//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int print2largest(List<Integer> arr) {
       if (arr == null || arr.size() < 2) {
           return -1;
       }
       
       int largest = Integer.MIN_VALUE;
       int secondLargest = Integer.MIN_VALUE;
       
       for (int i = 0; i < arr.size(); i++) {
           int current = arr.get(i);
           if (current > largest) {
               secondLargest = largest;
               largest = current;
           } else if (current > secondLargest && current != largest) {
               secondLargest = current;
           }
       }
       
       if (secondLargest == Integer.MIN_VALUE) {
           return -1;
       } else {
           return secondLargest;
       }
    }
}