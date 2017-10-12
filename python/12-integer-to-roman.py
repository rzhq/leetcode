#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        
        g = num % 10
        s = num % 100 / 10
        b = num % 1000 / 100
        q = num / 1000

        gs = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX']
        ss = ['', 'X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX', 'XC']
        bs = ['', 'C', 'CC', 'CCC', 'CD', 'D', 'DC', 'DCC', 'DCCC', 'CM']
        qs = ['', 'M', 'MM', 'MMM']

        return qs[q] + bs[b] + ss[s] + gs[g]
