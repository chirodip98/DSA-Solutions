// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class TheCowSignal {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String pattern[] = new String[M];
		for(int i=0;i<M;i++)
		{
			st =  new StringTokenizer(r.readLine());
			pattern[i]=st.nextToken();
		}

		String ansPattern[] = new String[M*K];

	int row=0;
	while(row<M)
	{
		String currString= "";
		for(int i=0; i<N; i++)
		{
			for(int j=0;j<K;j++)
			{
				currString+=pattern[row].charAt(i);
			}
		}
		row++;
		for(int j=0;j<K;j++)
			pw.println(currString);
		}

	
		pw.close();
	}
}
