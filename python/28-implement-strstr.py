#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        
        if not needle: return 0
        if not haystack: return -1
        if len(needle) > len(haystack): return -1

        for i in range(len(haystack)+1):
            for j in range(len(needle)+1):
                if j == len(needle): return i
                if i + j == len(haystack): return -1
                if needle[j] != haystack[i+j]: break
