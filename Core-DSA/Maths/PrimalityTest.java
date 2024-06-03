import java.util.*;
import java.io.*;  

class PrimalityTest
{
    public static boolean isPrime(int num)
    {
        if(num<=1) return false;

        for(int i=2;i*i<=num;i++)
        {
            if(num%i == 0)
                return false;
        }

        return true;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(reader.readLine());

        System.out.printf("is %d Prime ? : %s", num, isPrime(num));
    }
}