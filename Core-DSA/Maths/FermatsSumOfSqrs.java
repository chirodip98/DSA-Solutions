class FermatsSumOfSqrs
{
	public static void main(String args[])
	{
		int n=3;

		for(int i=2;i*i<=n;i++)
		{
			int count=0;
			if(n%i==0)
			{
				while(n%i!=0)
				{
					count++;
					n/=i;
				}
			}

			if((count%2 !=0) && i % 4 == 3) { System.out.println(false); return; }
		}

		System.out.println((n%4!=3)); 
		return;
	}
}