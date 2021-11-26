package com.practice;

public class Sample {


    // Find the maximum possible sum in arr[]
    // such that arr[m] is part of it
    static int maxCrossingSum(int arr[], int l, int m,int h)
    {
        // Include elements on left of mid.
    	System.out.println("In crossing sum method: left="+arr[l]+" and right - "+arr[h]+" m = "+arr[m]);
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        System.out.println("Calculate left sum..");
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }
        
        System.out.println("Left sum got "+left_sum);
 
        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        System.out.println("Calculate right sum..");
        
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }
 
        System.out.println("Right sum got "+right_sum);
        
        // Return sum of elements on left
        // and right of mid
        // returning only left_sum + right_sum will fail for
        // [-2, 1]
        
        System.out.println("Returning Math.max("+ left_sum +"+"+ right_sum+",Math.max("+left_sum+","+ right_sum+")");
        
        return Math.max(left_sum + right_sum,
                        Math.max(left_sum, right_sum));
    }
 
    // Returns sum of maximum sum subarray
    // in aa[l..h]
    static int maxSubArraySum(int arr[], int l, int h)
    {
        // Base Case: Only one element
    	System.out.println("In Maxsub array sum method: left="+arr[l]+" and right is "+arr[h]);
    	
        if (l == h)
        {
        	System.out.println("Left and right is same. Returning arr[l] - "+arr[l]);
            return arr[l];
        }
 
        // Find middle point
        
        int m = (l + h) / 2;
        System.out.println("Middle index is "+m+" - "+arr[m]);
        
        /* Return maximum of following three
        possible cases:
        a) Maximum subarray sum in left half
        b) Maximum subarray sum in right half
        c) Maximum subarray sum such that the subarray crosses the midpoint */
        
        System.out.println("Returning max of left_sum, right_sum and cross sum..");
        
        return Math.max(
            Math.max(maxSubArraySum(arr, l, m),maxSubArraySum(arr, m + 1, h)), maxCrossingSum(arr, l, m, h));
    }
	public static void main(String[] args)
    {
        int arr[] = { 1,2,3 };
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n - 1);
 
        System.out.println("Maximum contiguous sum is "
                           + max_sum);
       
        
    }
	
	
	
	
	
}
