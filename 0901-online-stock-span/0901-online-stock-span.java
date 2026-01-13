class StockSpanner {
    Stack<Integer> stack;
    Stack<Integer> span;
    public StockSpanner() {
        stack = new Stack<>();
        span = new Stack<>();
    }
    
    public int next(int price) {
        int spans = 1;
        while(!stack.isEmpty() && price >= stack.peek()){
            stack.pop();
            spans += span.pop();
        }
        stack.push(price);
        span.push(spans);
        return spans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */