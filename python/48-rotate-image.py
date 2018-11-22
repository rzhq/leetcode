#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        
        m = matrix
        for i in range(len(m)):
            for j in range(i):
                m[i][j], m[j][i] = m[j][i], m[i][j]
        for r in m:
            for i in range(int(len(r)/2)):
                r[i], r[~i] = r[~i], r[i]

def testFunc(m):
    Solution().rotate(m)
    return m

from dotest import DoTest
DoTest(testFunc).input(
    ([
  [1,2,3],
  [4,5,6],
  [7,8,9]
],),
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
],
    ([
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], ),
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
).run()

