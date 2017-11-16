#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        
        if not nums: return []

        p = 0
        q = 0
        l = len(nums)

        for i in range(1, l):
            if nums[-1-i] < nums[-i]:
                p = l - i - 1
                q = p + 1
                break
        if q > 0:
            for i in range(1, l):
                if nums[-i] > nums[p]:
                    nums[-i], nums[p] = nums[p], nums[-i]
                    break
        for i in range(q, p+(l-p+1)/2):
            nums[i], nums[q-i-1] = nums[q-i-1], nums[i]
