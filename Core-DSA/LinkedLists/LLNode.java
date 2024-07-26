package LinkedLists;

public class LLNode
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