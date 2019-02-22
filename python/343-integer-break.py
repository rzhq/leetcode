#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def integerBreak(self, n: 'int') -> 'int':
        q = int(n / 3)
        r = n % 3
        q2 = int(n / 2)
        if q <= 1:
            return q2 * (n - q2)
        elif r == 0:
            return 3 ** q
        elif r == 1:
            return 3 ** (q - 1) * 4
        elif r == 2:
            return 3 ** q * 2

from dotest import DoTest
DoTest(Solution().integerBreak).input(
    (2,), 1,
    (3,), 2,
    (10,), 36,
).run()
            
