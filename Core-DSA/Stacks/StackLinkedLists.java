class LLNode
{
	int data;
	LLNode next;

	public LLNode()
	{
		this.next = null;
	}

	public LLNode(int data)
	{
		this.data=data;
		this.next = null;
	}

	public LLNode(int data, LLNode next)
	{
		this.data=data;
		this.next = next;
	}

	@Override
	public String toString()
	{
		return "Node Value: "+this.data+" Pointing to: "+this.next;
	}
}

class SingleLinkedList
{
	LLNode head;
	LLNode curr;

	public SingleLinkedList()
	{
		this.head = null;
		this.curr=this.head;
	}

	public LLNode getHead()
	{
		return this.head;
	}

	public LLNode getcurrNode()
	{
		return this.curr;
	}

	public void insert(int data, int mode)
	{
		if(this.head == null)
		{
			LLNode temp = new LLNode(data);
			this.head = temp;
			this.curr=this.head;
			return;
		}
		switch(mode)
		{
			case 0:
			default : {

					System.out.println("Inserting at Tail");
					if(this.curr!=null)
					{
						LLNode temp = new LLNode(data);
						this.curr.next = temp;
						this.curr=temp;
					}
				break;
			}

			case 1 : {

					System.out.println("Inserting at Begining");
						LLNode temp = new LLNode(data);
						temp.next = this.head;
						this.head=temp;
				break;
			}
		}
	}

	public int delete(int mode)
	{
		if(this.head == null)
		{
			return -1;
		}

		switch(mode)
		{
			case 0:
			default : {

					System.out.println("Deleting at Tail");
						LLNode newCurr = this.head;
						if(newCurr == this.curr)  // deleting head
						{
							int val = this.curr.data;
							this.curr=newCurr;
							System.gc();
							return val;
						}
						while(newCurr.next!=this.curr) {newCurr=newCurr.next;}
						int val = this.curr.data;
						this.curr=newCurr;
						System.gc();
						return val;
			}

			case 1 : {

					System.out.println("Inserting at Begining");
						int val = this.head.data;
						this.head.next = this.head;
						System.gc();
						return val;
			}
		}

	}

}

class StackLLImpl
{
    int top=-1;
    SingleLinkedList LLIstance;

    public StackLLImpl()
    {
        this.LLIstance = new SingleLinkedList();
    }

    public void push(int data)
    {
        this.LLIstance.insert(data,0);
        this.top+=1;
    }

     public int peek()
    {
        if(this.top==-1) {System.out.println("Stack Underflow"); return -1;}
        return this.LLIstance.getcurrNode().data;
    }

     public int pop()
    {
        if(this.top==-1) {System.out.println("Stack Underflow"); return -1;}

        int x = this.LLIstance.delete(0);
        this.top-=1;
        return x;
    }

    public int get_size() {
		return this.top+1;
	}

    @Override
	public String toString()
	{
		return "Implementation of Stacks Using LinkedLists";
	}
}

public class StackLinkedLists
{
	public static void main(String args[])
	{
		StackLLImpl stacks = new StackLLImpl();
		System.out.println(stacks.toString());
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		stacks.push(7);
		stacks.push(8);
		stacks.push(9);
		stacks.push(10);
		stacks.push(11);
		System.out.println(stacks.peek());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
	}
}