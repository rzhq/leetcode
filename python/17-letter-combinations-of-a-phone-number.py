#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        
        if not digits: return []
        
        d = {'1': '*', '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'qprs', '8': 'tuv', '9': 'wxyz', '0': ' '}

        tmp = []
        l = list(d[digits[-1]])
        for i in xrange(-2, -len(digits), -1):
            tmp = l
            pre = list(d[digits[i]])
            l = []
            for j in pre:
                l.extend([j+x for x in tmp])
        return l
