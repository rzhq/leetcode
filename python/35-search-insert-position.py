#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        le = len(nums)
        n = nums
        t = target

        if le < 1:
            return 0
        if le == 1:
            if n[0] >= t:
                return 0
            else:
                return 1

        if n[0] >= t:
            return 0
        if n[-1] < t:
            return le
        if n[-1] == t:
            return le-1

        l = 0
        r = le - 1
        m = int(r / 2)

        while True:
            if n[m] == t:
                return m
            
            if n[m] > t:
                r = m
            elif n[m] < t:
                l = m
            if l + 1 == r:
                return r

            m = int(( l + r ) / 2)

from dotest import DoTest
DoTest(Solution().searchInsert).input(
    ([], 0), 0,
    ([1], 0), 0,
    ([1], 1), 0,
    ([0], 1), 1,
    ([1, 3], 0), 0,
    ([1, 3], 1), 0,
    ([1, 3], 2), 1,
    ([1, 3], 3), 1,
    ([1, 3], 4), 2,
    ([1, 3, 5], 0), 0,
    ([1, 3, 5], 1), 0,
    ([1, 3, 5], 2), 1,
    ([1, 3, 5], 3), 1,
    ([1, 3, 5], 4), 2,
    ([1, 3, 5], 5), 2,
    ([1, 3, 5], 6), 3,
).run()
