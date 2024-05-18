public class Manachers
{
	//https://leetcode.com/problems/longest-palindromic-substring/description/

	public static void manacherAlgo(String S)
	{
		String T = "";
		for(char ch : S.toCharArray())
		{
			T += "#" + ch;
		}

		T+="#";

		System.out.println("Preprocessed String: "+T);
		int P[] = new int[T.length()+1];
		int l=1 , r=1, maxlen=0, center=0;
		for(int i=1;i<=T.length();i++)
		{
			P[i]=Math.max(0, Math.min(r-i, P[r+l-i]));
			while(i-P[i]>=0 && i+P[i]<T.length() && T.charAt(i-P[i])==T.charAt(i+P[i])){ P[i]++; }
			if(i+P[i]>=r)
			{
				l=i-P[i]; //Updating our bounding box
				r=i+P[i];
			}

			if(P[i]>=maxlen)
			{
				center=i;
				maxlen=P[i];
			}
		}

		System.out.println("Longest Pallidrome length: "+(maxlen-1)+" Center: "+center);
		System.out.println("Longest Pallidrome: "+T.substring(center-maxlen+1,center+maxlen).replace("#",""));


	}
	public static void main(String args[])
	{
		Manachers.manacherAlgo("AAAAAAAAAAAAAA");
	}
}