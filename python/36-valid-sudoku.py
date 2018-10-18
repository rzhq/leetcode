#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:

    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """

        # check rows
        self.buff = [ {} for i in range(9) ]
        for i in range(9):
            if self.isDup(i, board[i]):
                return False

        # check cols
        self.buff = [ {} for i in range(9) ]
        for i in range(9):
            col = []
            for row in board:
                if self.isDupN(i, row[i]):
                    return False

        # check boxes
        self.buff = [ {} for i in range(9) ]
        for i in range(9):
            j = int(i / 3) * 3
            if self.isDup(j, board[i][0:3]):
                return False
            if self.isDup(j+1, board[i][3:6]):
                return False
            if self.isDup(j+2, board[i][6:9]):
                return False

        return True

    def isDupN(self, i, n):
        if '.' == n:
            return False
        if self.buff[i].get(n):
            return True
        else:
            self.buff[i][n] = n
            return False
        
    def isDup(self, i, nums):
        for n in nums:
            if self.isDupN(i, n):
                return True
        return False


from dotest import DoTest
DoTest(Solution().isValidSudoku).input(
    (
        [
          ["5","3",".",".","7",".",".",".","."],
          ["6",".",".","1","9","5",".",".","."],
          [".","9","8",".",".",".",".","6","."],
          ["8",".",".",".","6",".",".",".","3"],
          ["4",".",".","8",".","3",".",".","1"],
          ["7",".",".",".","2",".",".",".","6"],
          [".","6",".",".",".",".","2","8","."],
          [".",".",".","4","1","9",".",".","5"],
          [".",".",".",".","8",".",".","7","9"]
        ]
    ,), True,
    (
        [
            ["8","3",".",".","7",".",".",".","."],
            ["6",".",".","1","9","5",".",".","."],
            [".","9","8",".",".",".",".","6","."],
            ["8",".",".",".","6",".",".",".","3"],
            ["4",".",".","8",".","3",".",".","1"],
            ["7",".",".",".","2",".",".",".","6"],
            [".","6",".",".",".",".","2","8","."],
            [".",".",".","4","1","9",".",".","5"],
            [".",".",".",".","8",".",".","7","9"]
        ]
    ,), False,
).run()
