class BrowserHistory {
    LinkedList<String> ll;
    int size, curr;
    
    public BrowserHistory(String homepage) {
        ll = new LinkedList<>();
        ll.add(homepage);
        size = 0;
        curr = 0;        
    }
    
    public void visit(String url) {
        ll.add(curr+1,url);
        size = ++curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr-steps);
        return ll.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(size,curr+steps);
        return ll.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */