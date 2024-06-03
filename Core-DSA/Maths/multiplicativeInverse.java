import java.util.*;
import java.io.*;  

class multiplicativeInverse
{
    public static long multiInverse(int a, int b, int mod)
    {
        if(b==0) return 1;

        long res=1;
        
        while(b!=0)
        {
            if((b&1)==0)
            {
                a = (a * a)%mod;
                b= b >> 1;
            }
            else
            {
                res = (res * a)%mod;
                b--;
            }
        }

        return res;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(reader.readLine());
        int mod = 7;

        System.out.printf("Multiplicative Inverse of "+num+" is: "+multiplicativeInverse.multiInverse(num,mod-2, mod));
    }
}