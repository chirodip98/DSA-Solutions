import java.util.*;

public class MaxAreaHistogram
{
	public static long getMaxArea(int arr[])
	{
		Stack<Integer> stack = new Stack<>();
		int r=0, n=arr.length;

		if(n<=1) return (long)n;

		long area = Long.MIN_VALUE;

		while(r<n)
		{
			while(!stack.isEmpty() && arr[r] < arr[stack.peek()])
			{
				int ele = stack.pop();
				int nse = r;
				int pse = stack.isEmpty() ? -1 : stack.peek();
				area = Math.max(area, arr[ele] * (nse-pse-1));
			}
			stack.push(r);
			r+=1;
		}

		while(!stack.isEmpty())
			{
				int ele = stack.pop();
				int nse = n;
				int pse = stack.isEmpty() ? -1 : stack.peek();
				area = Math.max(area, arr[ele] * (nse-pse-1));
			}

			return area;
	}
	
	public static void main(String args[])
	{
		int arr[] = {2,1,5,6,2,3};
		System.out.println("Max Area of Rectangle is: "+getMaxArea(arr));
		return;
	}
}