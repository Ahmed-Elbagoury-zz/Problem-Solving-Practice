/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        // if(head.next == null){
        //     RandomListNode copyHead = new RandomListNode(head.label);
        //     if(head.random != null){
        //         RandomListNode random = new RandomListNode(head.label);
        //         copyHead.random = random;
        //     }
        //     return copyHead;
        // }
        //Insert copy of each node
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        //Set the random pointer of the copy nodes
        cur = head;
        while(cur != null){
            RandomListNode copy = cur.next;
            if(cur.random != null)
                copy.random = cur.random.next;
            cur = copy.next;    
        }
        //Set the next pointer of the copy nodes. And split the linkedList
        cur = head;
        RandomListNode copyHead = cur.next;
        RandomListNode curCopy = copyHead;
        while(curCopy != null && cur != null){
        	cur.next = curCopy.next;
            cur = cur.next;
            if(curCopy.next != null)
                curCopy.next = curCopy.next.next;    
                
            curCopy = curCopy.next;
        }
        return copyHead;
    }
}
