class Solution {

    /*  https://leetcode.com/problems/hand-of-straights/description/
        https://leetcode.com/problems/hand-of-straights/solutions/5266460/beats-100-explained-with-video-c-java-python-js-sorting-arrays-interview-solution/?envType=daily-question&envId=2024-06-06
    */

    //O(n)
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length%groupSize !=0) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i <hand.length; i++)
        {
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }

        for(int card : hand)
        {
            int startCard = card;
            while(map.getOrDefault(startCard-1, 0)>0) startCard--;

            while(startCard <= card)
            {
                while(map.getOrDefault(startCard,0)>0)
                {
                    for(int nextCard = startCard; nextCard < startCard+groupSize; nextCard++)
                    {
                        if(map.getOrDefault(nextCard, 0) == 0) return false;
                        map.put(nextCard, map.get(nextCard)-1);
                    }
                }
                startCard++;
            }
        }

        return true;
    }

    //O(nlogn + n)
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int i = 0;
        for (; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }
}