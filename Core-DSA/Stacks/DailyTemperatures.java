/*
	Input: temperatures = [73,74,75,71,69,72,76,73]
	Output: [1,1,4,2,1,1,0,0]
*/
class pair
{
    int temp;
    int day;

    public pair(int temp, int day)
    {
        this.temp = temp;
        this.day = day;
    }
}

public class DailyTemperature
{
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Stack<pair> stack = new Stack<>();
        int ans[] = new int[n];
        int ptr=0;
    
        while(ptr<n)
        {
            while(!stack.isEmpty() && stack.peek().temp < temperatures[ptr])
            {
                pair tempP = stack.pop();
                ans[tempP.day] = ptr - tempP.day;
            }

            stack.push(new pair(temperatures[ptr],ptr));
            ptr+=1;
        }

    return ans;
        
    }
}