#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        nums.sort()
        cs = 10000
        sm = 0
        for i in range(len(nums)):
            l = i + 1
            r = len(nums) - 1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if target == s:
                    return s

                d = abs(target - s)
                if d < cs:
                    cs = d
                    sm = s 
                if s < target:
                    l += 1
                    while l < r and nums[l] == nums[l-1]: l += 1
                else:
                    r -= 1
                    while l < r and nums[r] == nums[r+1]: r -= 1
        return sm
