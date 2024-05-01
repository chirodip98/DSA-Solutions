import java.io.*;
import java.util.*;

public class BucketList {
	static final int MAX_TIME = 1000;

	public static void main(String[] args) throws IOException {
		Scanner io = new Scanner(System.in);
		int n = io.nextInt();
    
		int[] change = new int[MAX_TIME + 1];
		for (int c = 0; c < n; c++) {
			int start = io.nextInt();
			int end = io.nextInt();
			int amt = io.nextInt();

			// at the start, we'll need some additional buckets
			change[start] += amt;
			// at the end, those buckets are no longer needed
			change[end] -= amt;
		}

		int maxBuckets = 0;  // max # of buckets we'll need
		int currBuckets = 0;  // # of buckets we need at the current processing time
		for (int t = 0; t < MAX_TIME; t++) {
			// update the # of buckets we're using
			currBuckets += change[t];
			// update the maximum accordingly
			maxBuckets = Math.max(maxBuckets, currBuckets);
		}

		System.out.println(maxBuckets);
		io.close();
	}

	
}