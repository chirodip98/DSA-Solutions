import java.util.*;
import java.io.*;  

class NumDivisors
{
    public static List<Integer> divisors(int num)
    {
        List<Integer> div = new ArrayList<>();
        for(int i=1;i*i<=num;i++)
        {
            if(num%i == 0)
            {
                if(!div.contains(i))
                    {
                        div.add(i);
                        if(!div.contains(num/i))
                            div.add(num/i);
                    }
            }
        }

        return div;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(reader.readLine());

        System.out.println(divisors(num).toString());
    }
}