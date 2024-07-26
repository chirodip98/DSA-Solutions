/*
	https://leetcode.com/problems/validate-stack-sequences/

	Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
	Output: true
	Explanation: We might do the following sequence:
	push(1), push(2), push(3), push(4),
	pop() -> 4,
	push(5),
	pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

	Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
	Output: false
	Explanation: 1 cannot be popped before 2.
 

*/

public class ValidateStackOperations
{
	public boolean validateStackSequences(int[] pushed, int[] popped) {

        int i =0, j=0, n=pushed.length;
        Stack<Integer> stack = new Stack<>();

        while(i<n)
        {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && (stack.peek() == popped[j]))
            {
               stack.pop(); j+=1;
            }
            i+=1;
        }

        return stack.isEmpty();
    }
}