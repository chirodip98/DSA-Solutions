/*
	https://leetcode.com/problems/asteroid-collision/
	Input: asteroids = [10,2,-5]
	Output: [10]
	Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
*/

public class AsteroidCollison
{
	public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        int r = 0;
        int n = asteroids.length;

        while (r < n) {
            int current = asteroids[r];

            while (!stack.isEmpty() && stack.peek() > 0 && current < 0) //Condition for Collison to Take place
            {
                int sum = stack.peek() + current;
                if (sum < 0) // Incoming element is of greater Magnitude moving in Left
                {
                    stack.pop();
                } else if (sum > 0) // Top element is of greater Magnitude moving in right
                {
                    current = 0;
                } else {
                    stack.pop(); // Both element are of equal Magnitude moving.
                    current = 0;
                }
            }
            if (current != 0)
                stack.push(current);
            r += 1;
        }

        n = stack.size();
        int ans[] = new int[n];
        int idx = n - 1;
        while (!stack.isEmpty()) {
            ans[idx] = stack.pop();
            idx -= 1;
        }

        return ans;

    }
}