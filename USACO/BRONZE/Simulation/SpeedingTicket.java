// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.StringTokenizer;

public class SpeedingTicket {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int OD[] = new int[100];
		int OL[] = new int[100];
		int pos = 0 , lim =0;

		for(int i=0; i<M; i++)
		{
			st = new StringTokenizer(r.readLine());
			int srt = Integer.parseInt(st.nextToken());
			lim = Integer.parseInt(st.nextToken());
			for(int j=pos;j< pos + srt; j++)
			{
				OD[j] = j;
				OL[j] = lim;
			}
			pos+=srt;
		}

		int BD[] = new int[100];
		int BL[] = new int[100];
		pos = 0;
		lim =0;
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(r.readLine());
			int srt = Integer.parseInt(st.nextToken());
			lim = Integer.parseInt(st.nextToken());
			for(int j=pos;j< pos + srt; j++)
			{
				BD[j] = j;
				BL[j] = lim;
			}
			
			pos+=srt;
		}

		int maxPenalty = 0;
		for(int i=0;i<100;i++)
		{
			maxPenalty = Math.max(maxPenalty , BL[i]-OL[i]);
		}

		pw.println(maxPenalty);
		pw.close();
	}
}
