public class LC303
{
	public static int patchNums(int arr[], int n)
	{
		int miss = 1;
		int result = 0;
		int i=0;

		while(miss <= n)
		{
			if(i<arr.length && arr[i] <= miss)
			{
				miss+=arr[i];  // 2 >> 7
				i++; // 1 >> 2
			}
			else
			{
				miss+=miss; //4
				result++; //1
			}
		}

		return result;
	}

	public static void main(String args[])
	{
		int nums[] = {1,3};
		int n =6;
		System.out.println(LC303.patchNums(nums, n));
	}
}