import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {

        public static int bruteGCD(int N1, int N2)
        {
            int GCD=1;
            for(int i = Math.min(N1,N2); i>=1;i--)
            {
                if(N1%i == 0 && N2%i ==0)
                    return i;
            }

            return GCD;
        }

        public static int eucledianGCD(int N1, int N2)
        {
            if(N2==0) return N1;
            return eucledianGCD(N2, N1%N2);
        }
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N1 =Integer.parseInt(reader.readLine());
        int N2 =Integer.parseInt(reader.readLine());

        System.out.println("GCD by BRUTE FORCE: "+bruteGCD(N1, N2));
        System.out.println("GCD by OPTIMAL: "+eucledianGCD(N1, N2));
    }
    
}
