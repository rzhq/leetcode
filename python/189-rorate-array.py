#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        l = len(nums)
        if l > 1:
            r = k % l
            t = nums[ : -r ]
            del nums[ : -r ]
            nums.extend(t)
