#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        
        if num1 is '0' or num2 is '0':
            return '0'
        
        m = len(num1)
        n = len(num2)
        ans = [ 0 for x in range(m+n) ]
        
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                num = int(num1[i]) * int(num2[j]) + ans[i+j+1]
                ans[i+j] += int(num / 10)
                ans[i+j+1] = num % 10

        x = 0
        s = ''
        while ans[x] is 0:
            x += 1
        for i in ans[x:]:
            s += str(i)
        return s

from dotest import DoTest
DoTest(Solution().multiply).input(
    ('2', '3'), '6',
    ('123', '456'), '56088',
    ('0', '3'), '0',
    ('123', '34'), '4182',
).run()
