#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        
        if head.next is None:
            return []
        h = head
        p = head
        for i in range(n):
            h = h.next
        if h is None:
            return head.next
        while h.next:
            h = h.next
            p = p.next
        if n == 1:
            p.next = None
        else:
            p.next = p.next.next
        return head
