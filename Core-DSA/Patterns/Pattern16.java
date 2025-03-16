
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-17
 */
public class Pattern16 {

    public static void objective(int n) {

        char ch ='A';
        for(int i=0; i<n; i++)
        {
            for(int s=0; s<n-i-1; s++)
            {
                System.out.print(" ");
            }

            for(int j=0; j<=i; j++)
            {
                ch = (char)('A'+j);
                System.out.print(ch);
            }

            for(int j =1; j<(i+1); j++)
            {
                ch = (char)(ch-1);
                System.out.print(ch);
            }

            System.out.println();
        }

    }

    public static void main(String args[])
    {
        Pattern16.objective(9);
    }
    
}
