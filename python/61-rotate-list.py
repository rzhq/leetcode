#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if k == 0 or not head:
            return head
        h = head
        n = 1
        while h.next:
            n += 1
            h = h.next
        h.next = head
        r = n - k % n
        if r == 0:
            return head
        for i in range(r):
            h = h.next
        head = h.next
        h.next = None
        return head
