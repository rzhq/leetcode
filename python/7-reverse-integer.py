#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        
        minus = False
        if x < 0:
            minus = True
            x = -x

        s = list(str(x))
        l = len(s)
        if l < 2:
            return x if not minus else -x

        for i in range(0, l / 2):
            j = l - i - 1
            s[i], s[j] = s[j], s[i]
        
        x = int(''.join(s))
        if x > 2147483647:
            return 0
        else:
            return x if not minus else -x
