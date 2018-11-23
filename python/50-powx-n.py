#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        
        if n is 0:
            return 1
        tmp = self.myPow(x, int(n/2))
        tmp = tmp * tmp
        if n % 2 == 0:
            return tmp
        else:
            if n > 0:
                return x * tmp
            else:
                return tmp / x

def testFunc(x, n):
    r = Solution().myPow(x, n)
    return round(r, 8)

from dotest import DoTest
DoTest(testFunc).input(
    (2, 10), 1024,
    (2.1, 3), 9.261,
    (2, -2), 0.25,
).run()
