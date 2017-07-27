#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        r = 0
        while n != 0:
            r = r + (n & 1)
            n = n >> 1
        return r
