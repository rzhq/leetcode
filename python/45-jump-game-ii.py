#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums) < 2:
            return 0
        lv = 0
        curMax = 0
        nxtMax = 0
        i = 0

        while curMax - i >= 0:
            lv += 1
            for j in range(i, curMax+1):
                nxtMax = max(nxtMax, nums[j] + j)
                if nxtMax >= len(nums)-1:
                    return lv
            i = curMax + 1
            curMax = nxtMax

        return -1

from dotest import DoTest
DoTest(Solution().jump).input(
    ([],), 0,
    ([4],), 0,
    ([3,2,1,0,4],), -1,
    ([2,3,1,1,4],), 2,
).run()
