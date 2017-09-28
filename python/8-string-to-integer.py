#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """

        if not str:
            return 0

        l = list(str)
        minus = False
        r = 0
        d = {
            '0': 0,
            '1': 1,
            '2': 2,
            '3': 3,
            '4': 4,
            '5': 5,
            '6': 6,
            '7': 7,
            '8': 8,
            '9': 9,
        }

        while l[0] == ' ':
            del l[0]

        if l[0] == '-':
            minus = True
            del l[0]
        elif l[0] == '+':
            del l[0]
            
        while len(l):
            n = l[0]
            del l[0]
            v = d.get(n, None)
            if v is not None:
                r = r * 10 + v 
            else:
                break;

        if minus:
            r = -r
        if r > 2147483647:
            r = 2147483647
        elif r < -2147483648:
            r = -2147483648

        return r
