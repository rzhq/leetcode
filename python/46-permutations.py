#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return self.DFS(nums)

    def BFS(self, nums):
        ans = [{'ans': [], 'rest': set(nums)}]
        for _ in nums:
            new_ans = []
            for a in ans:
                for n in a['rest']:
                    new_ans.append({'ans': a['ans']+[n], 'rest': a['rest']-{n}})
            ans = new_ans
        return [ x['ans'] for x in ans ]

    def DFS(self, nums):
        def get(res, ans, rest):
            if not rest:
                res.extend(ans)
            else:
                for r in rest:
                    get(res, [ x+[r] for x in ans ], rest-{r})
        res = []
        get(res, [ [] ], set(nums))
        return res

from dotest import DoTest
DoTest(Solution().permute).input(
    ([1,2,3],),
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ],
).run()
