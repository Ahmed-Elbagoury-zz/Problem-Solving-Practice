//http://oj.leetcode.com/problems/lru-cache/
public class LRUCache{
	  Entry head = new Entry (0, 0, null, null);
    Entry tail = new Entry (0, 0, null, null);
    Entry curEntry = head;
    HashMap<Integer, Entry> map = new HashMap<Integer, Entry> ();
    int capacity;
    int curSize = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        //init
        head = new Entry (0, 0, null, null);
        tail = new Entry (0, 0, null, head);
        head.next = tail;
        curEntry = head;
        map = new HashMap<Integer, Entry> ();
        capacity = 0;
        curSize = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        //get a pointer to the entry
        //remove it
        Entry req = map.get(key);
        if(req.prev == head) return req.value;
        req.prev.next = req.next;
        if(req.next != null) req.next.prev = req.prev;
        //add it to the head of the queue
        if(head.next != null) head.next.prev = req;
        req.next = head.next;
        req.prev = head;
        head.next = req;
        return req.value;
    }
    
    public void set(int key, int value) {
        if(capacity == 0) return;
        if(map.containsKey(key)){
            get(key);
            head.next.value = value;
            return;
        }
        if(curSize == capacity){//remove the tail
            Entry rem = tail.prev;
            tail.prev = rem.prev;
            rem.prev.next = tail;
            map.remove(rem.key);
            curSize --;
        }
        Entry newEntry = new Entry (key, value, head, head.next);
        map.put(key, newEntry);
        head.next.prev = newEntry;
        head.next = newEntry;
        curSize++;
    }
}

class Entry{
    public int key;
    public int value;
    public Entry next;
    public Entry prev;
    
    public Entry (int key, int value, Entry prev, Entry next){
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}