#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        
        MAX_INT = 2147483647
        minus = False
        if (dividend < 0 and divisor > 0) or (dividend > 0 and divisor < 0):
            minus = True
        divisor = abs(divisor)
        dividend = abs(dividend)

        if divisor > dividend:
            return 0

        res = 0
        while dividend >= divisor:
            d = divisor
            n = 1
            while d < dividend - d:
                n += n
                d += d
            dividend -= d
            res += n
        if minus:
            res = -res
        return res if res < MAX_INT else MAX_INT
