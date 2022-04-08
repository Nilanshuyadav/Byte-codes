class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int count;
    
    public MyLinkedList() {
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        this.count = 0;
        
        // Connect the head and tail;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if(index >= count) return -1;
        
        ListNode temp = getTheKthNode(index);
        return temp.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
        return;
    }
    
    public void addAtTail(int val) {
        addAtIndex(count, val);
        return;
    }
    
    public void addAtIndex(int index, int val) {
        // Do not append if the index is greater than the length of the linked list
        if(index > count) return;
        
        // The new node should be at the required index 
        ListNode temp = getTheKthNode(index-1);
        
        ListNode newNode = new ListNode(val);
        newNode.prev = temp;
        newNode.next = temp.next;
        
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        
        this.count++;
        return;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= count)  return;
        
        // Get to the node to be removed 
        ListNode temp = getTheKthNode(index);
        
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        
        this.count--;
        return;
    }
    
    private ListNode getTheKthNode(int index){
        ListNode temp = this.head;
        int k = index + 1;
        while(k != 0){
            temp = temp.next;
            k--;
        }
        
        return temp;
    }
    
    private class ListNode{
        public int val;
        public ListNode prev;
        public ListNode next;
        
        public ListNode(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}