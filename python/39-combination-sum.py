#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution:
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        t = target
        c = candidates
        buff = []
        ans = {}
        for i in c:
            buff.append((t-i, [i]))

        while buff:
            j, k = buff.pop()
            if j == 0:
                sk = sorted(k)
                ans[tuple(sk)] = sk
            else:
                for cc in c:
                    jj = j - cc
                    if jj >= 0:
                        kk = k[:]
                        kk.append(cc)
                        buff.append((jj, kk))

        return sorted(list(ans.values()))

from dotest import DoTest
DoTest(Solution().combinationSum).input(
    ([2,3,6,7], 7), [[2,2,3],[7]],
    ([1,2,3,4], 7), [[1,1,1,1,1,1,1],[1,1,1,1,1,2],[1,1,1,1,3],[1,1,1,2,2],[1,1,1,4],[1,1,2,3],[1,2,2,2],[1,2,4],[1,3,3],[2,2,3],[3,4]],
).run()
