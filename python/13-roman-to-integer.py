#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        if not s: return 0

        d = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        v = 0
        for i in range(1, len(s)):
            l = d[s[i-1]]
            r = d[s[i]]
            if l < r:
                v -= l
            else:
                v += l
        v += d[s[-1]]
        return v

    def prettierRomanToInt(self, s):
        """
        :type s: str
        :rtype: int
        surprisingly this one will take more time on leet code
        """

        if not s: return 0

        d = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        v = 0
        last = 0
        for i in s:
            curr = d[i]
            if last < curr:
                v -= last
            else:
                v += last
            last = curr
        v += last
        return v
