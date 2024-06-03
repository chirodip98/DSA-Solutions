
/*
    leetcode.com/problems/optimal-partition-of-string/description/
    Given a string s, partition the string into one or more substrings 
    such that the characters in each substring are unique. 
    That is, no letter appears in a single substring more than once.
    Return the minimum number of substrings in such a partition.
    Note that each character should belong to exactly one substring in a partition.

    We can use bit masking whenever we want to keep track of occurences

*/

class Optimal_partition_of_string {
    public int partitionString(String s) {

        int partitionCount=1; // the minimum no of partition we can have is 1 (entire string)
        int mask = 0, i=0;

        while(i < s.length())
        {
            int val = s.charAt(i) - 'a'; //getting the bit at ith character
            if( (mask & (1<<val))!=0) {mask=0; partitionCount+=1;} // Check if the ith bit has been previously set , we will create a partiton here and make the mask 0 again for fresh start
            mask = mask | (1<<val); //updating the mask to retain the progress so far
            i++;
        }
        
        return partitionCount;
    }
}