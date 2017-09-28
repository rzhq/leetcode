#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        def findPalindrome(s, l, r):
            if r - l - 1:
                p = s[l + 1]
            else:
                p = ''

            while l >= 0 and r < len(s) and s[l] == s[r]:
                p = s[l] + p + s[r]
                l = l - 1
                r = r + 1
            return p

        def longer(s1, s2):
            if len(s1) > len(s2):
                return s1
            else:
                return s2

        rec = ''
        for i in range(0, len(s)):
            rec = longer(findPalindrome(s, i-1, i+1), rec)
            rec = longer(findPalindrome(s, i, i+1), rec)
        return rec
