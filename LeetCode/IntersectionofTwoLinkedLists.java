/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //https://leetcode.com/problems/intersection-of-two-linked-lists/
 //http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class Solution {
    //O(n*m) time, O(1) memory
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        while(curA != null){
            ListNode curB = headB;
            while(curB != null){
                if(curB == curA)
                    return curB;
                curB = curB.next;    
            }
            curA = curA.next;
        }
        return null;
    }
    //O(n) memory, O(n+m) time
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        Set<ListNode> setA = new HashSet<ListNode>();
        ListNode curA = headA;
        while(curA != null){
            setA.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while(curB != null){
            if(setA.contains(curB))
                return curB;
            curB = curB.next;    
        }
        return null;
    }
    //O(n+m) time, O(1) memory
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        int countA = 0;
        while(curA != null){
            countA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        int countB = 0;
        while(curB != null){
            countB++;
            curB = curB.next;
        }
        ListNode largerHead = countA >= countB ? headA : headB;
        ListNode smallerHead = countA< countB ? headA : headB;
        int diff = Math.abs(countA-countB);
        for(int i =  0; i < diff; i++){
            largerHead = largerHead.next;
        }
        while(largerHead != null){
            if(largerHead == smallerHead)
                return largerHead;
            largerHead = largerHead.next;
            smallerHead = smallerHead.next;
        }
        return null;
    }
}
