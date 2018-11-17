#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        h = height
        if not height:
            return 0
        le = len(height)
        l = [ 0 for i in range(le) ]
        r = l[:]

        l[0] = h[0]
        r[-1] = h[-1]
        ans = 0

        for i in range(1, le):
            if l[i-1] > h[i]:
                l[i] = l[i-1]
            else:
                l[i] = h[i]
        for i in range(le-1, 0, -1):
            if r[i] > h[i-1]:
                r[i-1] = r[i]
            else:
                r[i-1] = h[i-1]
        for i in range(le):
            if l[i] < r[i]:
                m = l[i]
            else:
                m = r[i]
            ans += m - h[i]
        return ans

from dotest import DoTest
DoTest(Solution().trap).input(
    ([],), 0,
    ([1],), 0,
    ([0,1,0,2,1,0,1,3,2,1,2,1],), 6,
    ([0,1,5,2,1,2,1,1,2,4,2,1],), 15,
).run()
