//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        int a1 = l;
        int a2 = m + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(a1 <= m && a2 <= r) {
            if(arr[a1] < arr[a2]) {
                temp.add(arr[a1]);
                a1++;
            } else {
                temp.add(arr[a2]);
                a2++;
            }
        }
        
        while(a1 <= m) {
            temp.add(arr[a1]);
            a1++;
        }
        
        while(a2 <= r) {
            temp.add(arr[a2]);
            a2++;
        }
        
        for(int i = 0; i < temp.size(); i++) {
            arr[l + i] = temp.get(i);
        }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l >= r) {
            return;
        }
        
        int mid = (l + r) / 2;
        
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        
        merge(arr, l, mid, r);
    }
}
