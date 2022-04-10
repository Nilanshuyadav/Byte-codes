class MyLinkedList {
    
    class Node{
        Node next;
        Node pre;
        int val;
        
        public Node(int i){
            this.next = null;
            this.pre = null;
            this.val = i;
        }
        
    }
    
    Node head;
    Node tail;
    int size;
    
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
    
    public int get(int index) {
        Node curr = head.next;
        if(index>=size) return -1;
        while(index-->0)
            curr = curr.next;
        
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node toadd = new Node(val);
        toadd.next = head.next;
        head.next.pre = toadd;
        head.next = toadd;
        toadd.pre = head;
        size++;
    }
    
    public void addAtTail(int val) {
        Node toadd = new Node(val);
        tail.pre.next = toadd;
        toadd.pre = tail.pre;
        toadd.next = tail;
        tail.pre = toadd;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node toadd = new Node(val);
        Node curr = head;
        if(index>size) return;
        
        while(index-->0)
            curr = curr.next;
        
        toadd.next = curr.next;
        curr.next.pre = toadd;
        curr.next = toadd;
        toadd.pre = curr;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        Node curr = head;
        if(index>=size) return;
        while(index-->0)
            curr = curr.next;
        
        curr.next.next.pre = curr;
        curr.next = curr.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */