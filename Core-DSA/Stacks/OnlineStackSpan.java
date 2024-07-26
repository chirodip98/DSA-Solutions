class pair
{
    int data;
    int count;

    public pair(int data)
    {
        this.data=data;
        this.count=1;
    }
}
class StockSpanner {

    Stack<pair> stack;
    int size;
    public StockSpanner() {

        this.stack = new Stack<>();
        this.size=0;
    }
    
    public int next(int price) {

        pair p = new pair(price);
        while(!this.stack.isEmpty() && price >= this.stack.peek().data)
        {
            pair top = this.stack.pop();
            p.count+=top.count;
        }
        
        this.stack.push(p);
        return p.count;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */