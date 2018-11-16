#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        l = len(nums)
        ans = { x:x for x in range(1, l+2) }

        for i in nums:
            if i > 0 and ans.get(i):
                del ans[i]
        return list(ans.values())[0]

from dotest import DoTest
DoTest(Solution().firstMissingPositive).input(
    ([1,2,0],), 3,
    ([3,4,-1,1],), 2,
    ([7,8,9,11,12],), 1,
    ([],), 1,
    ([0],), 1,
    ([1],), 2,
    ([1,2,3],), 4,
    ([1,1],), 2,
).run() 
