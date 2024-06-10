/*
https://www.youtube.com/watch?v=UuiTKBwPgAo

Why we need two pointers: because we want to maximise the area. in this case width X height
thus we will take l=0, r=arr.length-1;

How to move the pointers?
we will move the pointer which points to the minimum height : Why because we want to 
maximise the area, I will try to find next potential height Which can be my Answer
eg: l=1 r=7 minHeight is 1
What if after 1 there is a large height like l=8 , r=7 minHeight = 7

*/


public class LC11 {
    public int maxArea(int[] height) {

        int l = 0, r = height.length-1, maxArea=Integer.MIN_VALUE;
        while(l<=r)
        {
            int LB = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, LB*(r-l));
            if(LB ==height[l]) l++;
            else r--;
        }
        
        return maxArea;
    }
}