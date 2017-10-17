#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        
        def gen(res, s, l, r):
            if l == 0 and r == 0:
                res.append(s)
            if l > 0:
                gen(res, s + '(', l-1, r)
            if l < r:
                gen(res, s + ')', l, r-1)

        if n == 0: return []
        res = []
        gen(res, '', n, n)
        return res
