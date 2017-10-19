# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import heapq

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """

        heap = []
        for i in lists:
            if i:
                heap.append((i.val, i))
        heapq.heapify(heap)
        h = ListNode(0)
        p = h

        while heap:
            node = heapq.heappop(heap)
            p.next = node[1]
            p = p.next
            if p.next:
                heapq.heappush(heap, (p.next.val, p.next))

        return h.next
