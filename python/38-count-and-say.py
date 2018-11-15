#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        
        s = '1'
        if n == 1:
            return s
        for _ in range(n-1):
            l = len(s)
            ans = ''
            i = 0
            j = 0
            while i < l and j < l:
                while j < l:
                    if s[i] == s[j]:
                        j += 1
                    else:
                        break
                ans += str(j-i) + s[i]
                i = j
            s = ans
        return s

from dotest import DoTest
DoTest(Solution().countAndSay).input(
    (1,), '1',
    (2,), '11',
    (3,), '21',
    (4,), '1211',
    (5,), '111221',
    (10,), '13211311123113112211',
).run()
