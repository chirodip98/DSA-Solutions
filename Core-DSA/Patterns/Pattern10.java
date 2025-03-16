
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-9
 */
public class Pattern10 {

    public static void objective(int n) {

        char ch = '*';
        for(int i=0; i<n; i++)
        {
            for(int s=0; s< n-i-1; s++)
            {
                System.out.print(" ");
            }

            for(int j=0; j<2*i+1; j++)
            {
                System.out.print(ch);
            }
            System.out.println();
        }

        for(int i=n; i>0; i--)
        {
            for(int s=0; s<n-i; s++)
            {
                System.out.print(" ");
            }
        
            //for character
            for(int j=0; j<2*i-1; j++)
            {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern10.objective(11);
    }
    
}
