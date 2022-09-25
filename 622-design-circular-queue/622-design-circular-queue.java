class MyCircularQueue {
    int size;
    int max_size;
    ListNode front, rear;
    public MyCircularQueue(int k) {
        size = 0;
        max_size = k;
        front = new ListNode();
        rear = front;
    }
    
    public boolean enQueue(int value) {
        if(size==max_size) return false;
        size++;
        ListNode temp = new ListNode(value);
        rear.next = temp;
        rear = temp;
        
        return true;
    }
    
    public boolean deQueue() {
        if(size==0) return false;
        size--;
        front = front.next;
        
        return true;
    }
    
    public int Front() {
        if(size==0) return -1;
        return front.next.val;
    }
    
    public int Rear() {
        if(size==0) return -1;
        return rear.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==max_size;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
    
    public ListNode(){
        this.val = 0;
        this.next = null;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */