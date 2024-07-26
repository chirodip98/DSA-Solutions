package LinkedLists;

import LinkedLists.LLNode;

class SingleLinkedList
{
	LLNode head;
	LLNode curr;

	public SingleLinkedList()
	{
		this.head = new LLNode();
		this.head = this.head.next;
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
			return;
		}
		switch(mode)
		{
			case 0:
			default : {

					System.out.println("Inserting at Tail");
					if(this.curr.next ==null)
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