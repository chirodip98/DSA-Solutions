package Stacks;

class StackArraysImp
{
	int top;
	int size;
	int container[]=null;

	public StackArraysImp(int size)
	{
		this.top=-1;
		this.size = size;
		this.container = new int[size];
	}


	public void push(int data)
	{
		if(this.top + 1 >= this.size) {System.out.println("Stack Overflow for "+data); return;}
		this.top+=1;
		this.container[this.top]=data;
	}

	public int pop()
	{
		if(this.top==-1) {System.out.println("Stack Underflow"); return -1;}
		int data = this.container[this.top];
		this.top-=1;
		return data;
	}

	public int peek()
	{
		if(this.top==0) {System.out.println("Stack Underflow"); return -1;}
		int data = this.container[this.top];
		return data;
	}

	public int get_size() {
		return this.top+1;
	}

	@Override
	public String toString()
	{
		return "Implementation of Stacks Using Arrays";
	}
}
public class StackArrays
{
	public static void main(String args[])
	{
		StackArraysImp stacks = new StackArraysImp(10);
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
	}
}