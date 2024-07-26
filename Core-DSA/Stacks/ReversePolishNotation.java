public class ReversePolishNotation
{
	public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while(idx< tokens.length)
        {
            if(Character.isDigit(tokens[idx].charAt(0)) || (tokens[idx].length()>1 && Character.isDigit(tokens[idx].charAt(1))))  // for cases like "-11"
            {
                stack.push(Integer.valueOf(tokens[idx]));
            }
            else
            {
                if(!stack.isEmpty() && stack.size()>=2)
                {
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = 0;
                    char ch = tokens[idx].charAt(0);
                    switch(ch)
                    {
                        case '+': { result = a + b; break;}
                        case '-': { result = b - a; break;}
                        case '*': { result = a * b; break;}
                        case '/': { result = b / a; break;}
                    }

                    stack.push(result);
                }
            }
            idx+=1;
        }
        
        return stack.pop();
    }
}