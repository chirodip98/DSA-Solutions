/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sum = new ListNode(0);
        ListNode curr = sum;
        int carry=0;
        int s =0 ;
        boolean f=false;

        while(true)
        {
            f=false;
            s=carry;
            if(l1!=null) { s+=l1.val; l1=l1.next; f=true;}
            if(l2!=null) { s+=l2.val; l2=l2.next; f=true;}
        
            if(f)
            {
                carry = s / 10;  // if sum is 21 I want to extract 2, hence /10
                ListNode node = new ListNode(s%10);
                curr.next = node;
                curr=curr.next;
            }
            else
                break;
            
        }

        //edge case Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]  Output: [8,9,9,9,0,0,0,1]
       if(carry!=0)
       {
            ListNode node = new ListNode(carry);
            curr.next = node;
       }

        return (sum.next);
    }
}