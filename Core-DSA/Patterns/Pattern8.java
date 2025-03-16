
/*
 * https://takeuforward.org/plus/dsa/beginner-problem/patterns/pattern-7
 */
public class Pattern8 {

    public static void objective(int n) {

        char space = ' ';
        char ch = '*';

        int counter = 1;
        
        for(int i=0; i<n; i++)
        {
            //Spaces at Start
            for(int s=0; s < n-i-1; s++)
            {
                System.out.print(space);
            }

            //for character
            for(int j=0; j<counter; j++)
            {
                System.out.print(ch);
            }

            counter+=2;
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Pattern8.objective(11);
    }
    
}
