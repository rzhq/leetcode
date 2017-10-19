# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        
        if k < 2 or not head: return head

        pre = ListNode(0)
        pre.next = head
        head = pre

        while pre.next:
            first = pre.next
            last = first
            p = first.next

            for i in range(k-1):
                last = last.next
                if last is None: return head.next

            for i in range(k-1):
                first.next = p.next
                p.next = pre.next
                pre.next = p
                p = first.next

            pre = first
        return head.next
