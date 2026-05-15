/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =
            new PriorityQueue<>(
                (a, b) -> a.val - b.val
            );
        for(ListNode node : lists) {
            if(node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!minHeap.isEmpty()) { 
            ListNode curr = minHeap.poll();
            tail.next = curr;
            tail = tail.next;
            if(curr.next != null) {
                minHeap.offer(curr.next);
            }
        }
        return dummy.next;
    }
}