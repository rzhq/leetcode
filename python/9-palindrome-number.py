#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """

        if x < 0:
            return False
        
        m = 1
        while x / m >= 10:
            m *= 10

        while x != 0:
            l = x / m
            r = x % 10
            if l != r:
                return False
            
            x = ( x % m ) / 10
            m /= 100
        
        return True

