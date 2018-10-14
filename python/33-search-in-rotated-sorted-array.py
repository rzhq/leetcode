#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        t = target
        n = nums
        i = 0
        j = len(nums) - 1

        if not n:
            return -1

        if j == 0:
            if n[0] == t:
                return 0
            else:
                return -1

        k = int(j / 2)

        while i < j:        
            if n[i] == t:
                return i
            if n[j] == t:
                return j
            if n[k] == t:
                return k
            if i + 1 == j:
                return -1

            if n[i] < n[k]:
                if n[i] < t and t < n[k]:
                    j = k
                else:
                    i = k
            else:
                if n[k] < t and t < n[j]:
                    i = k
                else:
                    j = k

            k = int(( i + j ) / 2)
