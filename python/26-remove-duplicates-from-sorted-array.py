#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums) < 2: return len(nums)
        
        c = 1
        for i in range(1, len(nums)):
            if nums[i-1] != nums[i]:
                nums[c] = nums[i]
                c += 1
            
        return c
