#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return

        h = head
        n1 = head

        mid = head
        while head and head.next:
            head = head.next.next
            mid = mid.next

        n2 = None
        m = mid.next
        while m:
            mid.next = n2
            n2 = mid
            mid = m
            m = m.next
        mid.next = n2
        n2 = mid

        while n2.next:
            tmp = n1.next
            tmp2 = n2.next
            n1.next = n2
            n1 = tmp
            n2.next = n1
            n2 = tmp2

        head = h
