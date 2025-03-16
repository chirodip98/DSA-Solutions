import java.util.Arrays;

public class QuickSort {

    public static void swap(int arr[], int l, int r)
    {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
        return;
    }

    public static int partition(int[] arr, int lo, int hi)
    {
        int pivot = arr[hi]; //lomuto's partitioning
        int idx=lo-1;
        for(int i=lo; i<hi; i++)
        {
            if(arr[i] <= pivot) { idx+=1; swap(arr, idx, i);}
        }

        swap(arr, idx+1, hi);
        return idx+1;
    }

    public static void quickSort(int arr[], int lo, int hi)
    {
        if(lo<hi)
        {
            int mid = partition(arr, lo, hi);
            quickSort(arr, lo, mid-1);
            quickSort(arr, mid+1, hi);
        }

        return;
    }

    public static void main(String[] args) {

        int nums[] = {1,3,6,2,9,4,5};
        QuickSort.quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return;
        
    }
    
}
