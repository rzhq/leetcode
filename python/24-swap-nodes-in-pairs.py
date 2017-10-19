#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        pre = ListNode(0)
        pre.next = head
        head = pre

        while pre.next and pre.next.next:
            tmp = pre.next
            pre.next = pre.next.next
            tmp.next = pre.next.next
            pre.next.next = tmp
            pre = pre.next.next
            
        return head.next
