#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        
        def formRows(r, m):
            rows = []
            for i in range(0, r - 1):
                rows.append([i])
            rows.append([])

            n = 1
            while True:
                bottom = ( r - 1 ) * ( 2 * n - 1)
                for i in range(0, r - 1):
                    num = bottom + i
                    if num > m:
                        return rows
                    rows[r - 1 - i].append(num)

                top = ( r - 1 ) * 2 * n
                for i in range(0, r - 1):
                    num = top + i
                    if num > m:
                        return rows
                    rows[i].append(num)
                n += 1

        l = len(s)

        if not s or numRows < 2 or not l or numRows > l:
            return s
        
        rows = formRows(numRows, l - 1)
        out = ''
        for r in rows:
            for rr in r:
                out += s[rr]
        return out
