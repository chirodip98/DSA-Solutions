import java.util.*;

//TC : O(n+k)

public class CountSort {
    
    public void countsort(int[] heights) {

        int max = Arrays.stream(heights).max().getAsInt(); // find the largest element of the array
        int n = heights.length;

        int freqMap[] = new int[max+1]; // declare a new array of size max+1
        int output[] = new int[n];
        int count=0;

        for(int i=0;i<n;i++)
            {
                freqMap[heights[i]]++;   // calculate frequencies of arr[i] and store in freqMap
            }

        for(int i=1;i<=max;i++)
            {
                freqMap[i]+=freqMap[i-1]; // calculate prefixSum on freqMap
            }

        for(int i=0;i<n;i++)
            {
                output[--freqMap[heights[i]]] = heights[i];    // Store the arr[i] at the index j where j = freqMap[arr[i]]-1, decreament freqMap[arr[i]] by 1
            }
        
    }
}