#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def spiralOrder(self, matrix: 'List[List[int]]') -> 'List[int]':
        if not matrix: return []
        if len(matrix) is 1:
            if isinstance(matrix[0], list): return matrix[0]
            else: return [matrix[0]]
        m = matrix
        row, col = len(matrix), len(matrix[0])
        seen = [ [False] * col for _ in matrix ]
        ans = []
        dr = [ 0, 1, 0 , -1]
        dc = [ 1, 0, -1, 0]
        c = r = di = 0
        for _ in range(row*col):
            ans.append(m[r][c])
            seen[r][c] = True
            rr, cc = r + dr[di], c + dc[di]
            if -1 < cc < col and -1 < rr < row and not seen[rr][cc]:
                r, c = rr, cc
            else:
                di = ( di + 1 ) % 4
                r, c = r + dr[di], c + dc[di]
        return ans

from dotest import DoTest
DoTest(Solution().spiralOrder).input(
    ([],), [],
    ([0],), [0],
    ([[0]],), [0],
    ([
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
    ],), [1,2,3,6,9,8,7,4,5],
    ([
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9,10,11,12]
    ],), [1,2,3,4,8,12,11,10,9,5,6,7],
).run()             
