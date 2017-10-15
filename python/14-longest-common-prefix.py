#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        if not strs: return ''
        if len(strs) == 1: return strs[0]
        
        f = strs[0]
        b = False
        cp = ''
        for i in range(0, len(strs[0])):
            for j in range(1, len(strs)):
                if f[:i+1] != strs[j][:i+1]:
                    b = True
                    break
            if b == True:
                break
            else:
                cp = f[:i+1]
        return cp
