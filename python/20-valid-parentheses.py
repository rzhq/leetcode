#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """

        stack = []
        d = ['(', '[', '{']
        r = {')': 0, ']': 1, '}': 2}
        for i in s:
            if i in d:
                stack.append(i)
            elif i in r:
                if stack and stack[-1] == d[r[i]]:
                    del stack[-1]
                else:
                    return False
        return stack == []
